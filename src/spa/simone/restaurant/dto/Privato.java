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

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

import spa.simone.restaurant.TipoCliente;

/**
 * @author Simone Spaccarotella {spa.simone@gmail.com}
 * 
 */
@Entity(name = "privato")
@PrimaryKeyJoinColumn(name = "id_cliente")
public final class Privato extends Cliente {

   private static final long serialVersionUID = -2048261565749924283L;
   private String nome;
   private String cognome;

   public Privato() {
      setTipo(TipoCliente.PRIVATO);
   }

   public String getNome() {
      return nome;
   }

   public String getCognome() {
      return cognome;
   }

   public void setNome(String nome) {
      this.nome = nome;
   }

   public void setCognome(String cognome) {
      this.cognome = cognome;
   }

   @Override
   public int hashCode() {
      final int prime = 31;
      int result = super.hashCode();
      result = prime * result + ((cognome == null) ? 0 : cognome.hashCode());
      result = prime * result + ((nome == null) ? 0 : nome.hashCode());
      return result;
   }

   @Override
   public boolean equals(Object obj) {
      if (this == obj) return true;
      if (!super.equals(obj)) return false;
      if (getClass() != obj.getClass()) return false;
      Privato other = (Privato) obj;
      if (cognome == null) {
	 if (other.cognome != null) return false;
      } else if (!cognome.equals(other.cognome)) return false;
      if (nome == null) {
	 if (other.nome != null) return false;
      } else if (!nome.equals(other.nome)) return false;
      return true;
   }

   @Override
   public String toString() {
      StringBuilder builder = new StringBuilder();
      builder.append("Privato [nome=");
      builder.append(nome);
      builder.append(", cognome=");
      builder.append(cognome);
      builder.append("]");
      return builder.toString();
   }

}