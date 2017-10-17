/*
MIT License

Copyright (c) 2017 Universidad de los Andes - ISIS2603

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
 */
package co.edu.uniandes.csw.decide.ejb;



import co.edu.uniandes.csw.decide.entities.PoliticoEntity;
import co.edu.uniandes.csw.decide.exceptions.BusinessLogicException;

import co.edu.uniandes.csw.decide.persistence.DefaultPersistence;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author ISIS2603
 */
@Stateless
public class DefaultLogic {

    private static final Logger LOGGER = Logger.getLogger(DefaultLogic.class.getName());

    @Inject
    private DefaultPersistence persistence; // Variable para acceder a la persistencia de la aplicación. Es una inyección de dependencias.

    /**
     *
     * @param entity
     * @return
     * @throws BusinessLogicException
     */
    public PoliticoEntity createDefault(PoliticoEntity entity) throws BusinessLogicException {
        LOGGER.info("Inicia proceso de creación de Default");
        // Invoca la persistencia para crear la Default
        persistence.create(entity);
        LOGGER.info("Termina proceso de creación de Default");
        return entity;
    }

    /**
     * 
     * Obtener todas las Defaultes existentes en la base de datos.
     *
     * @return una lista de Defaultes.
     */
    public List<PoliticoEntity> getDefaults() {
        LOGGER.info("Inicia proceso de consultar todas las Defaultes");
        // Note que, por medio de la inyección de dependencias se llama al método "findAll()" que se encuentra en la persistencia.
        List<PoliticoEntity> Default = persistence.findAll();
        LOGGER.info("Termina proceso de consultar todas las Defaultes");
        return Default;
    }


}
