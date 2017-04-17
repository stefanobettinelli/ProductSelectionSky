package com.stefanobettinelli.productselectionsky.dao;

import com.stefanobettinelli.productselectionsky.exceptions.InvalidSkyIdException;
import com.stefanobettinelli.productselectionsky.model.Category;
import com.stefanobettinelli.productselectionsky.model.IntegerSkyId;
import com.stefanobettinelli.productselectionsky.model.SimpleCategory;
import com.stefanobettinelli.productselectionsky.model.SkyId;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StaticCategoryDAO implements entityDAO{

    public final static SkyId NEWS_CAT_ID = IntegerSkyId.getNewId(1);
    public final static SkyId SPORTS_CAT_ID = IntegerSkyId.getNewId(2);
    public final static SkyId SPORTS_NEWS_CAT_ID = IntegerSkyId.getNewId(3);

    private final static Map<SkyId, Category> CATEGORY_MAP = new HashMap<>();

    static {
        CATEGORY_MAP.put(NEWS_CAT_ID, new SimpleCategory(NEWS_CAT_ID, "News"));
        CATEGORY_MAP.put(SPORTS_CAT_ID, new SimpleCategory(SPORTS_CAT_ID, "Sports"));
        CATEGORY_MAP.put(SPORTS_NEWS_CAT_ID, new SimpleCategory(SPORTS_NEWS_CAT_ID, "Sport News"));
    }

    public static Map<SkyId, Category> getCategories(){
        return CATEGORY_MAP;
    }


    @Override
    public List loadAll() {
        return null;
    }

    @Override
    public Object loadById(SkyId id) {
        return null;
    }
}
