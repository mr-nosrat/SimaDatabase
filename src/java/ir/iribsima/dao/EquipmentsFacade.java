/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ir.iribsima.dao;

import ir.iribsima.entities.Equipments;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author admin
 */
@Stateless
public class EquipmentsFacade extends AbstractFacade<Equipments> {
    @PersistenceContext(unitName = "SimaDatabase19PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EquipmentsFacade() {
        super(Equipments.class);
    }
    
}
