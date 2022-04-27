from django.urls import path
from login.views import *

urlpatterns = [
    path('', home),
    path('db/<int:employeeId>', db)
    
]