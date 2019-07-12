from django.contrib import admin
from django.conf.urls import url
from django.urls import path
from .views import *

urlpatterns = [
    path('admin/', admin.site.urls),
    url('alspost', alspost, name='alspost'),
    url('oldage', oldage, name='oldage'),
]
