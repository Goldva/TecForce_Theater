package com.tecforce.theater.services.DataServices;

import com.tecforce.theater.data.entities.EntityInterface;

import java.util.List;

public interface DataServiceInterface {
    void add(EntityInterface entity);

    EntityInterface getById(long entityId);

    List<EntityInterface> getAll();

    EntityInterface getEntity(EntityInterface entity);

    List<EntityInterface> getEntities(EntityInterface entity);

    void update(EntityInterface entity);

    void delete(long entityId);

}
