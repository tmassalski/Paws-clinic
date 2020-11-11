WORK IN PROGRESS

Basic veterinary clinic service

- REST api
- Swagger
- Spring security(authentication, authorization, account activation via email)
- Spring Data JPA
- Postgres DB

Swagger UI available under https://paws-clinic.herokuapp.com

PUT, DELETE requests available only to admin.
/users endpoint is accessible to everybody.

for admin privileges use login: beastmaster, password: beastmaster
for user privileges use login: user, password: user
to logout/switch account go to https://paws-clinic.herokuapp.com/logout

To create new user go to /users/activation (admin privileges only).
New users requires activation by confirming token received via email.
You can use https://10minutemail.net for testing.

