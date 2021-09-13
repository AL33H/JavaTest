package br.com.SigaBem.entities;

public class CEP {

       /*
                                          ATTRIBUTES
        */

       private String cep;
       private String uf;
       private String ddd;

       /*
                                          CONSTRUCTOR'S
        */

       public CEP() {
       }

       public CEP(String cep, String uf, String ddd) {
              this.cep = cep;
              this.uf = uf;
              this.ddd = ddd;
       }

       /*
                                          GETTER'S AND SETTER'S
        */

       public String getCep() {
              return cep;
       }

       public void setCep(String cep) {
              this.cep = cep;
       }

       public String getUf() {
              return uf;
       }

       public void setUf(String uf) {
              this.uf = uf;
       }

       public String getDdd() {
              return ddd;
       }

       public void setDdd(String ddd) {
              this.ddd = ddd;
       }

       /*
                                          METHODS
        */

       @Override
       public String toString() {
              return "CEP{" +
                      "cep='" + cep + '\'' +
                      ", uf='" + uf + '\'' +
                      ", ddd='" + ddd + '\'' +
                      '}';
       }
}
