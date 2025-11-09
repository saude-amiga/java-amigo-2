## **1. Ferramentas Necessárias**

1. **IntelliJ IDEA**

   * Versão recomendada: **Ultimate Edition** ou Community.
   * Link: [https://www.jetbrains.com/idea/download/](https://www.jetbrains.com/idea/download/)

2. **Java JDK 21**

   * Link: [https://www.oracle.com/java/technologies/javase/jdk21-archive-downloads.html](https://www.oracle.com/java/technologies/javase/jdk21-archive-downloads.html)

3. **Oracle SQL Developer** (opcional, para visualizar dados no banco remoto)

   * Link: [https://www.oracle.com/tools/downloads/sqldev-downloads.html](https://www.oracle.com/tools/downloads/sqldev-downloads.html)

4. **Maven**  
   - O IntelliJ já possui integração com o Maven.

5. **Postman**

   - Ferramenta para testar as rotas da API.  
   - Link: [https://www.postman.com/downloads/](https://www.postman.com/downloads/)

---

## **2. Preparar o Ambiente**

1. Instale **JDK 21** e configure `JAVA_HOME`.
2. Instale **IntelliJ IDEA**. Configure o **Project SDK** para JDK 21:

   * `File → Project Structure → Project → Project SDK → Add → JDK → selecione JDK 21`

3. Instale o **Postman** para testar as rotas do projeto.
---

## **3. Importar Projeto Quarkus no IntelliJ**

1. Abra IntelliJ → **File → Open** → selecione a pasta `saude-amiga`.
2. Escolha **pom.xml** e abra como projeto Maven.
3. Aguarde o IntelliJ baixar dependências do Maven.

---

## **4. Assertar Conexão com o Banco Remoto**

> ⚠️ Certifique-se de que você tem acesso ao banco remoto da rede onde o Oracle está hospedado.

---

## **5. Rodar a Aplicação**

1. No IntelliJ, abra o terminal do projeto e execute:

   ```bash
   ./mvnw quarkus:dev
   ```

2. A aplicação será iniciada localmente em:

   ```
   http://localhost:8080
   ```

## **6. Testar Endpoints com o Postman**

1. Abra o **Postman**.  
2. Clique em **Import** → selecione o arquivo `sprint-4-java.postman_collection2.json` disponível na pasta raíz do projeto.
3. A coleção **"sprint-4-java"** será adicionada à sua biblioteca de requisições.  
4. No canto superior direito do Postman, clique em **Environment → Add** (ou **Gerenciar Variáveis Globais**) e crie a variável:
   - **Nome:** `baseURL`  
   - **Valor:** `http://localhost:8080/`  
5. Agora todas as requisições da coleção (como `Usuario`, `Agendamento`, `Pergunta` e `Acesso`) irão usar o endereço local da sua aplicação.  
6. Clique em qualquer rota, altere seus valores e pressione **Send** para testá-la.


## **7. No caso do teste na aplicação remota**
1. A aplicação também pode ter sua versão hospedada testadaa usando o endpoint `https://api-saude-amiga.onrender.com/` como valor de baseURL. 

2. O ambiente do postman para o acesso desta mesma aplicação hospedada pode ser rapidamente acessado usando o seguinte link:
`https://www.postman.com/aviation-astronaut-85642828/sprint-4-java-saude-amiga/collection/f8xfw1q/sprint-4-java?action=share&creator=30054948&tab=variables`