package group.project.api.managers;

import group.project.api.exceptions.ManagerException;

public interface IManager<Id, Obj> {

    Obj find(Id id)         throws ManagerException;

    void create(Obj obj)    throws ManagerException;

    void update(Obj object) throws ManagerException;

    void delete(Id id) throws ManagerException;

}
