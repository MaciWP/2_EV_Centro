# Agregar alumnos
curl -X POST http://localhost:8080/alumnos/add \
-H "Content-Type: application/json" \
-d '{"nombre": "Miguel", "apellido": "Hernandez", "fechaNacimiento": "2006-03-15", "email": "miguel.hernandez@centro.com", "curso": {"id": 1}}'

# Agregar profesores
curl -X POST http://localhost:8080/profesores/add \
-H "Content-Type: application/json" \
-d '{"nombre": "Laura", "apellido": "Martinez", "email": "laura.martinez@centro.com"}'

# Obtener todos los alumnos de la base de datos
curl -X GET http://localhost:8080/alumnos/getAll

# Obtener todos los alumnos de un curso indicado por parámetros
curl -X GET http://localhost:8080/alumnos/curso/1

# Obtener todos los profesores de un curso indicada por parámetros
curl -X GET http://localhost:8080/profesores/curso/2

# Obtener el curso que se imparte en un aula indicada por parámetros
curl -X GET http://localhost:8080/cursos/aula/3

# Obtener el nombre de todos los cursos que imparte un profesor
curl -X GET http://localhost:8080/cursos/profesor/2/nombres

# Obtener aulas con capacidad mayor de 30 (lo he forzado para cumplir el enunciado)
curl -X GET http://localhost:8080/aulas/capacidad30