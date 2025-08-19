# HealthTrack Platform

## 🚀 Descripción del Proyecto
HealthTrack es una plataforma para el seguimiento y control de la salud de los usuarios. Permite registrar datos de usuarios, actualizar su peso, y calcular métricas como el IMC (Índice de Masa Corporal).

## 🛠️ Tecnologías Utilizadas
- Java 17
- Spring Boot 3.1.0
- Maven
- JUnit 5
- JaCoCo
- SonarQube
- GitHub Actions

## 📁 Estructura del Proyecto
```
healthtrack-platform/
├── .github/workflows/    - Configuración de CI/CD
├── src/
│   ├── main/             - Código fuente principal
│   └── test/             - Pruebas unitarias e integración
├── tests/performance/    - Pruebas de rendimiento con JMeter
```

## 🚀 Características Principales
- Gestión de usuarios (CRUD)
- Cálculo automático del IMC
- Categorización del estado de salud según IMC
- Actualización de peso con validaciones

## 🔧 Instalación y Ejecución

### Prerrequisitos
- Java 17 o superior
- Maven 3.6 o superior

### Instalación
```bash
# Clonar el repositorio
git clone https://github.com/tu-usuario/healthtrack-platform.git
cd healthtrack-platform

# Compilar el proyecto
mvn clean install
```

### Ejecución
```bash
# Ejecutar la aplicación
mvn spring-boot:run
```

### Pruebas
```bash
# Ejecutar todas las pruebas
mvn test

# Generar informe de cobertura
mvn jacoco:report

# Ver informe de cobertura
# Abrir en navegador: target/site/jacoco/index.html
```

## 📊 Análisis de Calidad
El proyecto está configurado con SonarQube para análisis continuo de calidad:

```bash
# Análisis local
mvn sonar:sonar -Dsonar.login=tu-token
```

## 🚢 Pipeline CI/CD
El proyecto utiliza GitHub Actions para automatizar:
- Compilación y pruebas
- Análisis de cobertura con JaCoCo
- Análisis de calidad con SonarQube
- Notificaciones a Slack

## 📝 Ejemplos de API
### Crear Usuario
```http
POST /api/usuarios
{
  "nombre": "Juan",
  "apellido": "Pérez",
  "fechaNacimiento": "1990-01-01",
  "altura": 1.75,
  "peso": 70.0
}
```

### Actualizar Peso
```http
PATCH /api/usuarios/1/peso?nuevoPeso=75.0
```

### Obtener IMC
```http
GET /api/usuarios/1/imc
```

## 📄 Licencia
Este proyecto está bajo la Licencia MIT. Ver el archivo LICENSE para más detalles.
