package com.gacrnd.gcs.algorithm.designpatterns.entity;


import com.gacrnd.gcs.algorithm.designpatterns.action.visit.Visit;

/**
 * 水果接口
 */
public interface Fruit {

    int price();

    void draw();

    int accept(Visit visit);

}
