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
package spa.simone.restaurant.dao;

/**
 * @author Simone Spaccarotella {spa.simone@gmail.com}
 * 
 */
public class DaoFactory {

   private static AccordoDao accordoDao;
   private static AziendaDao aziendaDao;
   private static CameriereDao cameriereDao;
   private static CategoriaDao categoriaDao;
   private static IngredienteDao ingredienteDao;
   private static MenuFissoDao menuFissoDao;
   private static OrdinazioneDao ordinazioneDao;
   private static PietanzaDao pietanzaDao;
   private static PrenotazioneDao prenotazioneDao;
   private static PrivatoDao privatoDao;
   private static TavoloDao tavoloDao;

   public static AccordoDao getAccordoDao() {
      if (accordoDao == null) {
	 accordoDao = new AccordoDao();
      }
      return accordoDao;
   }

   public static AziendaDao getAziendaDao() {
      if (aziendaDao == null) {
	 aziendaDao = new AziendaDao();
      }
      return aziendaDao;
   }

   public static CameriereDao getCameriereDao() {
      if (cameriereDao == null) {
	 cameriereDao = new CameriereDao();
      }
      return cameriereDao;
   }

   public static CategoriaDao getCategoriaDao() {
      if (categoriaDao == null) {
	 categoriaDao = new CategoriaDao();
      }
      return categoriaDao;
   }

   public static IngredienteDao getIngredienteDao() {
      if (ingredienteDao == null) {
	 ingredienteDao = new IngredienteDao();
      }
      return ingredienteDao;
   }

   public static MenuFissoDao getMenuFissoDao() {
      if (menuFissoDao == null) {
	 menuFissoDao = new MenuFissoDao();
      }
      return menuFissoDao;
   }

   public static OrdinazioneDao getOrdinazioneDao() {
      if (ordinazioneDao == null) {
	 ordinazioneDao = new OrdinazioneDao();
      }
      return ordinazioneDao;
   }

   public static PietanzaDao getPietanzaDao() {
      if (pietanzaDao == null) {
	 pietanzaDao = new PietanzaDao();
      }
      return pietanzaDao;
   }

   public static PrenotazioneDao getPrenotazioneDao() {
      if (prenotazioneDao == null) {
	 prenotazioneDao = new PrenotazioneDao();
      }
      return prenotazioneDao;
   }

   public static PrivatoDao getPrivatoDao() {
      if (privatoDao == null) {
	 privatoDao = new PrivatoDao();
      }
      return privatoDao;
   }

   public static TavoloDao getTavoloDao() {
      if (tavoloDao == null) {
	 tavoloDao = new TavoloDao();
      }
      return tavoloDao;
   }

}