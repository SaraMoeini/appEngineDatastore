package com.wecashup.tryIt;


import static com.googlecode.objectify.ObjectifyService.ofy;

import java.util.List;
import java.util.logging.Logger;

import com.googlecode.objectify.cmd.Query;


public class Reader {

	final Logger log = Logger.getLogger(Writer.class.getName());
	int QUERY_SIZE = 100;

	// Default constructor
	public Reader() {

	}

	/**
	 * 
	 * @param entitiyToRead
	 * @return a given entity loaded from its key (contained in the entityToRead
	 *         object)
	 */

	public <T> T load(T entitiyToRead) {
		T entity = ofy().load().entity(entitiyToRead).now();

		if (entity != null) {
			log.info(entity.toString());
		}

		return entity;
	}

	public  <T> List<? extends Object> loadAll(Class<T> entitiyToRead) {

		List<? extends Object> result = null;

		Query<? extends Object> query = ofy().load().type(entitiyToRead);

		if (query != null) {
			result = query.list();
		}

		return result;
	}

	/**
	 * 
	 * @param entitiyToRead
	 * @param entitiyToRead_id
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public <T> T load_with_id(T entitiyToRead, Long entitiyToRead_id) {

		T entity = (T) ofy().load().type(entitiyToRead.getClass()).id(entitiyToRead_id).now();

		if (entity != null) {
			log.info(entity.toString());
		}

		return entity;
	}

	public <T> T load_with_id(Class<T> entitiyToRead, Long entitiyToRead_id) {

		T entity = (T) ofy().load().type(entitiyToRead).id(entitiyToRead_id).now();

		if (entity != null) {
			log.info(entity.toString());
		}

		return entity;
	}

	/*@SuppressWarnings("unchecked")
	public <T> T load_with_uid(T entityClass, String entitiyToRead_uid) {
		return (T) load_with_uid(entityClass.getClass(), entitiyToRead_uid);
	}

	public <T> T load_with_uid(Class<T> entityClass, String entitiyToRead_uid) {
		T entity = null;
		try {



		} catch (Exception e) {
			e.printStackTrace();
		}

		return entity;
	}*/

	@SuppressWarnings("unchecked")
	public <T> T load_1_with_1_filter(T entitiyToRead, String entitiyFilter1, String entityFilterValue1) {
		T entity = null;
		try {
			log.info(entitiyToRead.getClass().getName() + " entity");
			entity = (T) ofy().load().type(entitiyToRead.getClass()).filter(entitiyFilter1, entityFilterValue1)
					.first().now();
			if (entity != null) {
				log.info(entity.toString());
			} else {
				log.info("Entity not found.");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return entity;
	}
	
	@SuppressWarnings("unchecked")
	public <T> T list_load_1_with_1_filter(T entitiyToRead, String entitiyFilter1, String entityFilterValue1) {
		T entity = null;
		try {
			log.info(entitiyToRead.getClass().getName() + " entity");
			entity = (T) ofy().load().type(entitiyToRead.getClass()).filter(entitiyFilter1, entityFilterValue1)
					.first().now();
			if (entity != null) {
				log.info(entity.toString());
			} else {
				log.info("Entity not found.");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return entity;
	}
}
