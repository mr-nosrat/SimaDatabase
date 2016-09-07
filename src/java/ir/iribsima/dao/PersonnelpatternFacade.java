/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ir.iribsima.dao;

import ir.iribsima.entities.Personnelpattern;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author admin
 */
@Stateless
public class PersonnelpatternFacade extends AbstractFacade<Personnelpattern> {
    @PersistenceContext(unitName = "SimaDatabase19PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PersonnelpatternFacade() {
        super(Personnelpattern.class);
    }
    
}
