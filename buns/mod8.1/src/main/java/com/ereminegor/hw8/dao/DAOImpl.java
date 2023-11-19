package com.ereminegor.hw8.dao;

import com.ereminegor.hw8.entity.Emp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.util.List;

@Repository
public class DAOImpl implements DAO {

    @Autowired
    private EntityManager manager;

    @Override
    public List<Emp> getAll() {

        Query query = manager.createQuery("from Employee");
        return query.getResultList();
    }

    @Override
    public void save(Emp employee) {
        //Session session = manager.unwrap(Session.class);
        //session.saveOrUpdate(employee);
        Emp newEmp = manager.merge(employee);
        employee.setId(newEmp.getId());
    }

    @Override
    public Emp getEmployee(int id) {
        //Session session = manager.unwrap(Session.class);
        //Employee employee = session.get(Employee.class, id);
        return manager.find(Emp.class, id);
    }

    @Override
    public void delete(int id) {
        //Session session = manager.unwrap(Session.class);
        //Employee employee = session.get(Employee.class, id);
        //session.delete(employee);
        //Query<Employee> query = session.createQuery("delete from Employee where id =:empId");
        //query.setParameter("empId", id);
        //query.executeUpdate();

        Query query = manager.createQuery("delete from Employee where id =:empId");
        query.setParameter("empId", id);
        query.executeUpdate();
    }
}
