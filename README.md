# Microservicios Sistema de Logística para una Empresa Distribuidora de Farmacéuticos

## Descripción
Este proyecto es un sistema integral de logística diseñado para una empresa distribuidora de farmacéuticos. El sistema abarca los procesos de compra, almacenamiento y venta de productos farmacéuticos utilizando una arquitectura de microservicios.

## Tabla de Contenidos
- [Características Principales](#características-principales)
- [Tecnologías Utilizadas](#tecnologías-utilizadas)
- [Contribución](#contribución)

## Características Principales
- **Service doc-compras**: Microservicio para gestionar ordenes de compra y facturas de compra.
- **Service-producto**: Microservicio para gestionar los productos con sus lotes respectivos, ademas de generar otros documentos importantes de almacen.
- **Service-cotizacion**: Microservicio para gestionar la cotizacion tanto de venta como de compra de farmaceuticos.
- **Service-empleado**: Microservicio para la gestion de los empleados de la empresa
- **Service-proveedor**: Microservicio para la gestion de los proveedor de la empresa.
- **gateway**: El intermediario entre el back y el front.
- **Service-auth**: Servidor de autorizacion basado en oauth2 con JWT

## Tecnologías Utilizadas
- **Backend**: Java, Spring Boot, OAuth2, JWT
- **Base de Datos**: SQL Server
- **Nube**: Azure App Services
- **Herramientas**: Git, Docker

## Se desplego en Azure App Service usando una subcripcion gratuita. !!ACTUALMENTE VENCIDA
