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

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

/**
 * @author Simone Spaccarotella {spa.simone@gmail.com}
 * 
 */
@Entity(name = "categoria")
public final class Categoria implements Serializable {

   private static final long serialVersionUID = -6467257312939571287L;
   private Long id;
   private String nome;
   private Set<MenuFisso> menuFissi = new HashSet<MenuFisso>();
   private Set<Pietanza> pietanze = new HashSet<Pietanza>();

   public Categoria() {
   }

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   public Long getId() {
      return id;
   }

   public String getNome() {
      return nome;
   }

   @ManyToMany(mappedBy = "categorie")
   public Set<MenuFisso> getMenuFissi() {
      return menuFissi;
   }

   @OneToMany(mappedBy = "categoria")
   public Set<Pietanza> getPietanze() {
      return pietanze;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public void setNome(String nome) {
      this.nome = nome;
   }

   protected void setMenuFissi(Set<MenuFisso> menuFissi) {
      this.menuFissi = menuFissi;
   }

   public boolean addMenuFisso(MenuFisso menuFisso) {
      return this.menuFissi.add(menuFisso);
   }

   public boolean removeMenuFisso(MenuFisso menuFisso) {
      return this.menuFissi.remove(menuFisso);
   }

   protected void setPietanze(Set<Pietanza> pietanze) {
      this.pietanze = pietanze;
   }

   public boolean addPietanza(Pietanza pietanza) {
      return this.pietanze.add(pietanza);
   }

   public boolean removePietanza(Pietanza pietanza) {
      return this.pietanze.remove(pietanza);
   }

   @Override
   public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((id == null) ? 0 : id.hashCode());
      result = prime * result + ((nome == null) ? 0 : nome.hashCode());
      return result;
   }

   @Override
   public boolean equals(Object obj) {
      if (this == obj) return true;
      if (obj == null) return false;
      if (getClass() != obj.getClass()) return false;
      Categoria other = (Categoria) obj;
      if (id == null) {
	 if (other.id != null) return false;
      } else if (!id.equals(other.id)) return false;
      if (nome == null) {
	 if (other.nome != null) return false;
      } else if (!nome.equals(other.nome)) return false;
      return true;
   }

   @Override
   public String toString() {
      StringBuilder builder = new StringBuilder();
      builder.append("Categoria [id=");
      builder.append(id);
      builder.append(", nome=");
      builder.append(nome);
      builder.append("]");
      return builder.toString();
   }

}
