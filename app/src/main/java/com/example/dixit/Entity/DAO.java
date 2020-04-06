package com.example.dixit.Entity;

import java.util.List;

public  interface  DAO<T> {
   T create( T obj);
   boolean update (T obj);
   boolean delete (String id);
   List<T> getAll();

}
