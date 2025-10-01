package fiap.sprint.domain.model;

import java.util.Date;

public class Acesso {
   private int id;
   private Date dataAcesso;
   private int idPagina;

   public Acesso(int id, Date dataAcesso, int idPagina) {
      this.id = id;
      this.dataAcesso = dataAcesso;
      this.idPagina = idPagina;
   }

   public Acesso(Date dataAcesso, int idPagina) {
      this.dataAcesso = dataAcesso;
      this.idPagina = idPagina;
   }

   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public Date getDataAcesso() {
      return dataAcesso;
   }

   public void setDataAcesso(Date dataAcesso) {
      this.dataAcesso = dataAcesso;
   }

   public int getIdPagina() {
      return idPagina;
   }

   public void setIdPagina(int idPagina) {
      this.idPagina = idPagina;
   }
}
