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

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * @author Simone Spaccarotella {spa.simone@gmail.com}
 * 
 */
@Entity(name = "cameriere")
public final class Cameriere implements Serializable {

   private static final long serialVersionUID = -1184862462368095470L;
   private Long id;
   private String nome;
   private String cognome;
   private Integer stipendio;
   private Set<Ordinazione> ordinazioni = new HashSet<Ordinazione>();

   public Cameriere() {
   }

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   public Long getId() {
      return id;
   }

   @Column(nullable = false)
   public String getNome() {
      return nome;
   }

   @Column(nullable = false)
   public String getCognome() {
      return cognome;
   }

   @Column(length = 7)
   public Integer getStipendio() {
      return stipendio;
   }

   @OneToMany(mappedBy = "cameriere")
   public Set<Ordinazione> getOrdinazioni() {
      return ordinazioni;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public void setNome(String nome) {
      this.nome = nome;
   }

   public void setCognome(String cognome) {
      this.cognome = cognome;
   }

   public void setStipendio(Integer stipendio) {
      this.stipendio = stipendio;
   }

   protected void setOrdinazioni(Set<Ordinazione> ordinazioni) {
      this.ordinazioni = ordinazioni;
   }

   public boolean addOrdinazione(Ordinazione ordinazione) {
      return this.ordinazioni.add(ordinazione);
   }

   public boolean removeOrdinazione(Ordinazione ordinazione) {
      return this.ordinazioni.remove(ordinazione);
   }

   @Override
   public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((cognome == null) ? 0 : cognome.hashCode());
      result = prime * result + ((id == null) ? 0 : id.hashCode());
      result = prime * result + ((nome == null) ? 0 : nome.hashCode());
      result = prime * result + ((stipendio == null) ? 0 : stipendio.hashCode());
      return result;
   }

   @Override
   public boolean equals(Object obj) {
      if (this == obj) return true;
      if (obj == null) return false;
      if (getClass() != obj.getClass()) return false;
      Cameriere other = (Cameriere) obj;
      if (cognome == null) {
	 if (other.cognome != null) return false;
      } else if (!cognome.equals(other.cognome)) return false;
      if (id == null) {
	 if (other.id != null) return false;
      } else if (!id.equals(other.id)) return false;
      if (nome == null) {
	 if (other.nome != null) return false;
      } else if (!nome.equals(other.nome)) return false;
      if (stipendio == null) {
	 if (other.stipendio != null) return false;
      } else if (!stipendio.equals(other.stipendio)) return false;
      return true;
   }

   @Override
   public String toString() {
      StringBuilder builder = new StringBuilder();
      builder.append("Cameriere [id=");
      builder.append(id);
      builder.append(", nome=");
      builder.append(nome);
      builder.append(", cognome=");
      builder.append(cognome);
      builder.append(", stipendio=");
      builder.append(stipendio);
      builder.append("]");
      return builder.toString();
   }

}
