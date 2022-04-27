from django.db import connection
from django.http import HttpResponse, HttpResponseNotFound
from django.shortcuts import render



def home(request):
    return render(request, 'login/about.html')

def pageNotFound(request, exception):
    return HttpResponseNotFound('<h1>Page not found<h1>')

def db(request, employeeId):
    with connection['hr_db'].cursor() as c:
        c.execute(f'SELECT * from EMPLOYEES WHERE EMPLOYEE_ID = {employeeId}')
    return HttpResponse (dictfetchall(c))

def dictfetchall(cursor):
    "Return all rows from a cursor as a dict"
    columns = [col[0] for col in cursor.description]
    return [
        dict(zip(columns, row))
        for row in cursor.fetchall()
    ]
