from django.shortcuts import redirect,render
import pyrebase
from django.http import HttpResponse

config = {
  'apiKey': "AIzaSyCIlaOwqVS_nowErO5oe1KVIXVeSPvWqLU",
  'authDomain': "myproject-8aa14.firebaseapp.com",
  'databaseURL': "https://myproject-8aa14.firebaseio.com",
  'projectId': "myproject-8aa14",
  'storageBucket': "",
  'messagingSenderId': "367272916912",
  'appId': "1:367272916912:web:4512d8c411625cc4"
}

firebase=pyrebase.initialize_app(config)
auth =firebase.auth()
database=firebase.database()

def alspost(request):
    data = request.POST.get('data')
    if int(data) == 1:
      data = "is requesting food"
    elif int(data) == 2:
      data = "is requesting your assistance."
    database.child("Root").child("Task").push({'Task': data, 'taskFrom': "Cristiano Ronaldo", 'taskTo': 0})
    return HttpResponse(status = 200)



def oldage(request):
  data = request.POST.get('data', -1)
  if int(data) > -1:
    if int(data) == 0:
      data = "is requesting food."
    elif int(data) == 1:
      data = "is requesting water."
    else:
      data = "requesting your assistance."
    database.child("Root").child("Task").push({'Task': data, 'taskFrom': "Lionel Messi", 'taskTo': 0})
  return render(request, 'AppAPI/index.html', {})