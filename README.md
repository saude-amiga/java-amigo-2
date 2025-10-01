## **1. Ferramentas Necessárias**

1. **IntelliJ IDEA**

   * Versão recomendada: **Ultimate Edition** ou Community.
   * Link: [https://www.jetbrains.com/idea/download/](https://www.jetbrains.com/idea/download/)

2. **Java JDK 21**

   * Link: [https://www.oracle.com/java/technologies/javase/jdk21-archive-downloads.html](https://www.oracle.com/java/technologies/javase/jdk21-archive-downloads.html)

3. **Oracle SQL Developer** (opcional, para visualizar dados no banco remoto)

   * Link: [https://www.oracle.com/tools/downloads/sqldev-downloads.html](https://www.oracle.com/tools/downloads/sqldev-downloads.html)

4. **Maven** (IntelliJ já integra Maven)

---

## **2. Preparar o Ambiente**

1. Instale **JDK 21** e configure `JAVA_HOME`.
2. Instale **IntelliJ IDEA**. Configure o **Project SDK** para JDK 21:

   * `File → Project Structure → Project → Project SDK → Add → JDK → selecione JDK 21`

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

1. Execute o método main da classe Main clicando na seta verde ao lado do nome do método.

