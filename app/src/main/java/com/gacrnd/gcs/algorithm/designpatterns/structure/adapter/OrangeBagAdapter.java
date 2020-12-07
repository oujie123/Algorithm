package com.gacrnd.gcs.algorithm.designpatterns.structure.adapter;

import com.gacrnd.gcs.algorithm.designpatterns.entity.bag.AppleBag;
import com.gacrnd.gcs.algorithm.designpatterns.entity.bag.OrangeBag;

/**
 * 桔子包装适配器
 */
public class OrangeBagAdapter extends OrangeBag {
    private AppleBag appleBag;

    public OrangeBagAdapter(AppleBag appleBag){
        this.appleBag = appleBag;
    }

    @Override
    public void pack() {
        appleBag.pack();
    }
}
