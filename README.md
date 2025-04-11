
# 🛠️ SistemaOS – Gerenciamento de Ordens de Serviço

O **SistemaOS** é uma aplicação web desenvolvida com **Java Spring Boot** para auxiliar no gerenciamento de ordens de serviço em oficinas ou empresas de assistência técnica. O sistema permite o cadastro de clientes, registro de serviços, controle de status das ordens e geração de relatórios.

---

## 🚀 Tecnologias Utilizadas

- **Java 17**
- **Spring Boot**
- **Spring Data JPA**
- **Thymeleaf**
- **MySQL**
- **Maven**

---

## ⚙️ Como Executar o Projeto

1. **Clone o repositório:**
   ```bash
   git clone https://github.com/p-pedroSantos/sistemaOS.git
   cd sistemaOS
   
2. Configure o banco de dados:**
   Atualize as credenciais no arquivo src/main/resources/application.properties:
   ```bash
   spring.datasource.url=jdbc:mysql://localhost:3306/sistema_os
   spring.datasource.username=seu_usuario
   spring.datasource.password=sua_senha


 

3. Execute a aplicação:
   ```bash
   ./mvnw spring-boot:run

4. Acesse no navegador:
   ```bash
   http://localhost:8080
---
## 📁 Estrutura do Projeto
   ```
   sistemaOS/  
   ├── src/  
   │   ├── main/  
   │   │   ├── java/                # Código-fonte Java  
   │   │   └── resources/           # Templates e configurações  
   │   └── test/                    # Testes automatizados  
   ├── pom.xml                      # Configurações do Maven  
   └── README.md                    # Documentação do projeto
```
---
## 📝 Funcionalidades Planejadas
- **Cadastro e gerenciamento de clientes**

- **Registro e acompanhamento de ordens de serviço**

- **Controle de status (aberto, em andamento, concluído)**

- **Geração de relatórios em PDF**

- **Autenticação de usuários**
---
👨‍💻 Autor
Pedro Santos
