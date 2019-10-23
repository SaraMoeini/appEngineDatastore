package com.wecashup.tryIt;

import static com.googlecode.objectify.ObjectifyService.ofy;

import java.util.logging.Logger;

import com.googlecode.objectify.Key;
import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.Work;

public class Writer {
	
	final Logger log = Logger.getLogger(Writer.class.getName());
	
	static {
		
		try{
			/* ATTENTION ADD THE ENTITY CLASS HERE
			*/
			ObjectifyService.register(User.class);		
		}catch(Throwable t){
	 		t.printStackTrace();
	 	}
        
    }

	//Default constructor
	public Writer(){
		
	}
	
	/**
	 * The method to call to store a list of entities (one or more) in the datastore
	 * @param <T>
	 * @return 
	 */
		@SuppressWarnings("unchecked")
		public <T> boolean save(T entitiesToSave){
			boolean resp = false;
			
			try{
				log.info("entitiesToSave class : "+entitiesToSave.getClass());
				if(ofy().save().entities(entitiesToSave).now() != null){
					resp = true;
				}else{
					log.info("unable to save");
				}
			}catch(Exception e){
				e.printStackTrace();
			}
			
			return resp;
		}
		
		/**
		 * 
		 * @param entitiesToSave
		 * @return the id of the saved entity
		 */
		public <T> Long save_getId(T entitiesToSave){
			
			final T thing = entitiesToSave;
			
			Long resp = null;
			
			try{
				resp = ofy().transact(new Work<Long>() {
				    public Long run() {

				        Key<T> id = ofy().save().entity(thing).now();

				        log.warning(("WRITER return Entity KEY : "+id.getId()));
				        return id.getId();
				    }
				});
			}catch(Exception e){
				e.printStackTrace();
			}
			
			
		
			
			return resp;
		}
		
		/**
		 * 
		 * @param old_entity
		 * @param new_entity
		 * @return the id of the new_entity after saving it. (Save old, then save new and return new's id)
		 */
		public <T> Long save_transactionally(T old_entity, T new_entity){
			final T old_e = old_entity;
			final T new_e = new_entity;

			Long resp = null;
			
			try{
				resp = ofy().transact(new Work<Long>() {
				    public Long run() {
				    	
				    	Key<T> old_id = ofy().save().entity(old_e).now();
				    	
				    	log.warning(("WRITER saved old entity : "+old_id.getId()));
				    	try {
							Thread.sleep(2000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}

				        Key<T> new_id = ofy().save().entity(new_e).now();

				        log.warning(("WRITER return Entity KEY : "+new_id.getId()));
				        return new_id.getId();
				    }
				});
			}catch(Exception e){
				e.printStackTrace();
			}
			
			return resp;
		}

		
}
