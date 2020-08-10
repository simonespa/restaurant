/*
 * This file is part of Restaurant project.
 * 
 * Restaurant is a java project for the second assignment of Enterprise Application. 
 * Copyright (C) 2011 Simone Spaccarotella {spa.simone@gmail.com}
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package spa.simone.restaurant.dto;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;

import spa.simone.restaurant.TipoCliente;

/**
 * @author Simone Spaccarotella {spa.simone@gmail.com}
 * 
 */
@Entity(name = "azienda")
@PrimaryKeyJoinColumn(name = "id_cliente")
public final class Azienda extends Cliente {

   private static final long serialVersionUID = -8550347960168301245L;
   private String nome;
   private Indirizzo indirizzo;
   private Set<Accordo> accordi = new HashSet<Accordo>();

   public Azienda() {
      setTipo(TipoCliente.AZIENDA);
   }

   @Column(nullable = false, unique = true)
   public String getNome() {
      return nome;
   }

   @Embedded
   public Indirizzo getIndirizzo() {
      return indirizzo;
   }

   @OneToMany(mappedBy = "azienda")
   public Set<Accordo> getAccordi() {
      return accordi;
   }

   public void setNome(String nome) {
      this.nome = nome;
   }

   public void setIndirizzo(Indirizzo indirizzo) {
      this.indirizzo = indirizzo;
   }

   protected void setAccordi(Set<Accordo> accordi) {
      this.accordi = accordi;
   }

   public boolean addAccordo(Accordo accordo) {
      return this.accordi.add(accordo);
   }

   public boolean removeAccordo(Accordo accordo) {
      return this.accordi.remove(accordo);
   }

   @Override
   public int hashCode() {
      final int prime = 31;
      int result = super.hashCode();
      result = prime * result + ((indirizzo == null) ? 0 : indirizzo.hashCode());
      result = prime * result + ((nome == null) ? 0 : nome.hashCode());
      return result;
   }

   @Override
   public boolean equals(Object obj) {
      if (this == obj) return true;
      if (!super.equals(obj)) return false;
      if (getClass() != obj.getClass()) return false;
      Azienda other = (Azienda) obj;
      if (indirizzo == null) {
	 if (other.indirizzo != null) return false;
      } else if (!indirizzo.equals(other.indirizzo)) return false;
      if (nome == null) {
	 if (other.nome != null) return false;
      } else if (!nome.equals(other.nome)) return false;
      return true;
   }

   @Override
   public String toString() {
      StringBuilder builder = new StringBuilder();
      builder.append("Azienda [nome=");
      builder.append(nome);
      builder.append(", indirizzo=");
      builder.append(indirizzo);
      builder.append("]");
      return builder.toString();
   }

}
