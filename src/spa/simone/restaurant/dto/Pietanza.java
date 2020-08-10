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

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.ForeignKey;

/**
 * @author Simone Spaccarotella {spa.simone@gmail.com}
 * 
 */
@Entity(name = "pietanza")
public final class Pietanza extends ItemOrdinazione {

   private static final long serialVersionUID = 6481415106339461071L;
   private String descrizione;
   private Set<Ingrediente> ingredienti = new HashSet<Ingrediente>();
   private Categoria categoria;

   public Pietanza() {
   }

   public String getDescrizione() {
      return descrizione;
   }

   @ManyToMany
   @JoinTable(name = "pietanza_ingrediente", joinColumns = @JoinColumn(name = "id_pietanza"), inverseJoinColumns = @JoinColumn(name = "id_ingrediente"))
   @ForeignKey(name = "FK_PIETANZA-INGREDIENTE_PIETANZA", inverseName = "FK_PIETANZA-INGREDIENTE_INGREDIENTE")
   public Set<Ingrediente> getIngredienti() {
      return ingredienti;
   }

   @ManyToOne
   @JoinColumn(name = "id_categoria")
   @ForeignKey(name = "FK_CATEGORIA")
   public Categoria getCategoria() {
      return categoria;
   }

   public void setDescrizione(String descrizione) {
      this.descrizione = descrizione;
   }

   protected void setIngredienti(Set<Ingrediente> ingredienti) {
      this.ingredienti = ingredienti;
   }

   public boolean addIngrediente(Ingrediente ingrediente) {
      return this.ingredienti.add(ingrediente);
   }

   public boolean removeIngrediente(Ingrediente ingrediente) {
      return this.ingredienti.remove(ingrediente);
   }

   public void setCategoria(Categoria categoria) {
      this.categoria = categoria;
   }

   @Override
   public int hashCode() {
      final int prime = 31;
      int result = super.hashCode();
      result = prime * result + ((categoria == null) ? 0 : categoria.hashCode());
      result = prime * result + ((descrizione == null) ? 0 : descrizione.hashCode());
      result = prime * result + ((ingredienti == null) ? 0 : ingredienti.hashCode());
      return result;
   }

   @Override
   public boolean equals(Object obj) {
      if (this == obj) return true;
      if (!super.equals(obj)) return false;
      if (getClass() != obj.getClass()) return false;
      Pietanza other = (Pietanza) obj;
      if (categoria == null) {
	 if (other.categoria != null) return false;
      } else if (!categoria.equals(other.categoria)) return false;
      if (descrizione == null) {
	 if (other.descrizione != null) return false;
      } else if (!descrizione.equals(other.descrizione)) return false;
      if (ingredienti == null) {
	 if (other.ingredienti != null) return false;
      } else if (!ingredienti.equals(other.ingredienti)) return false;
      return true;
   }

   @Override
   public String toString() {
      StringBuilder builder = new StringBuilder();
      builder.append("Pietanza [descrizione=");
      builder.append(descrizione);
      builder.append(", ingredienti=");
      builder.append(ingredienti);
      builder.append(", categoria=");
      builder.append(categoria);
      builder.append("]");
      return builder.toString();
   }

}