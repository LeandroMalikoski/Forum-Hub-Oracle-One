#  FÓRUM HUB ORACLE ONE 📚
API REST
## Descrição 💎
* Esta é uma API Rest STATELESS, que utiliza metódos CRUDS para manipulação de tópicos do Fórum.
## Funcionalidades 💎
* Autenticação
* Cadastro de novos Tópicos.
* Listagem de todos Tópicos,
* Listagem de Tópico detalhada,
* Atualização de Tópico,
* Exclusão de Tópico.
## Exemplos de como utilizar🚀
💎url base: http://localhost:8080/topicos💎<br/>
💎Autenticação💎<br/>
Envio
``` java
{
  "login": "usuario@exemplo.com",
  "senha": "senha123"
}
```
Retorno
``` java
"token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJBUEkgRm9ydW0gSHViIiwic3ViIjoibGVhbmRyb0Bmb3J1bSIsImV4cCI6MTczNjU0OTU3M30.-Zeeg1AGaWW7fikwoXLDymOCo3yiz8FEAaaXTjefFys"
```
Coloque esse token na aba Auth -> Bearer Token, será necessário em todas as outras requisições.
💎Cadastro de Tópicos💎<br/>
Exemplo de envio de Body
``` java
{
	"autor": "AutorExemplo",
	"titulo": "DuvidaExemplo",
	"mensagem": "MensagemExemplo",
	"curso": "CursoExemplo"
}
```
Retorno
``` java
{
	"id": 1,
	"autor": "AutorExemplo",
	"titulo": "DuvidaExempo",
	"mensagem": "MensagemExemplo",
	"dataCriacao": "2025-01-10T18:49:05",
	"status": "NAO_RESPONDIDO",
	"curso": "CursoExemplo"
}
```
💎Listagem de Tópicos💎
``` java
	"content": [
		{
			"id": 2,
      "titulo": "DuvidaExemplo",
    	"mensagem": "MensagemExemplo",
			"dataCriacao": "2025-01-10T14:56:08"
		},
		{
			"id": 3,
    	"titulo": "DuvidaExemplo",
    	"mensagem": "MensagemExemplo",
			"dataCriacao": "2025-01-10T14:56:35"
		},
	]
```
💎Listagem detalhada💎
url = http://localhost:8080/topicos/{id}
``` java
{
	"id": 1,
	"autor": "AutorExemplo",
	"titulo": "DuvidaExempo",
	"mensagem": "MensagemExemplo",
	"dataCriacao": "2025-01-10T18:49:05",
	"status": "NAO_RESPONDIDO",
	"curso": "CursoExemplo"
}
```
💎Atualização de Tópico💎
url = http://localhost:8080/topicos/{id}
Envio de dados que deseja substituir
``` java
{
	"autor": "AutorExemplo",
	"titulo": "DuvidaExemplo",
	"mensagem": "MensagemExemplo",
	"curso": "CursoExemplo"
}
```
💎Exclusão de Tópico💎
url = http://localhost:8080/topicos/{id}
Digite o id para exclusão
💎Banco de dados💎<br/>
Utilização de váriaveis de ambiente
```
spring.datasource.url=jdbc:mysql://${DB_HOST}/${DB_NAME}
spring.datasource.username=${DB_USER}
spring.datasource.password=${DB_PASSWORD}

spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

api.security.token.secret=${JWT_SECRET:12345}
```
## Ferramentas Utilizadas 🛠️ 
* Java
* Spring boot 3.4.1
* Maven
* MySql
* Insomnia
* TokenJWT

Autor: Leandro Malikoski<br>
Contato: leandroborgesmalikoski@gmail.com<br>
GitHub: https://github.com/leandromalikoski
