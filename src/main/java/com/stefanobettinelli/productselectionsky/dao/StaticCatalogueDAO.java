/**
 * Static container for Catalogue Data
 * most of the methods and properties are static to test real functionality
 * developer che implement enetityDAO to retrieve real data from DB or other sources for example
 */

package com.stefanobettinelli.productselectionsky.dao;

import com.stefanobettinelli.productselectionsky.model.*;

import java.util.*;

public class StaticCatalogueDAO implements entityDAO{

    private final static SkyId ARSERNAL_TV_ID = IntegerSkyId.getNewId(1);
    private final static SkyId CHELSEA_TV_ID = IntegerSkyId.getNewId(2);
    private final static SkyId LIVERPOOL_TV_ID = IntegerSkyId.getNewId(3);
    private final static SkyId SKY_NEWS_ID = IntegerSkyId.getNewId(4);
    private final static SkyId SKY_SPORTS_ID = IntegerSkyId.getNewId(5);

    private final static Map<SkyId, Product> PRODUCT_MAP = new HashMap<>();
    private final static Map<SkyId, Category> CATEGORY_MAP = StaticCategoryDAO.getCategories();
    private final static Map<SkyId, List<SkyId>> LOCATION_TO_PRODUCTS_MAP = new HashMap<>();

    static {
        Location londonLocation = StaticLocationDAO.getLocationById(StaticLocationDAO.LONDON_LOCATION_ID);
        Location liverpoolLocation = StaticLocationDAO.getLocationById(StaticLocationDAO.LIVERPOOL_LOCATION_ID);

        SimpleProduct arsenalTV = new SimpleProduct(ARSERNAL_TV_ID, "Arsenal TV", CATEGORY_MAP.get(StaticCategoryDAO.SPORTS_CAT_ID), Collections.singletonList(londonLocation));
        SimpleProduct chelseaTV = new SimpleProduct(CHELSEA_TV_ID, "Chelsea TV", CATEGORY_MAP.get(StaticCategoryDAO.SPORTS_CAT_ID), Collections.singletonList(londonLocation));
        SimpleProduct liverpoolTV = new SimpleProduct(LIVERPOOL_TV_ID, "Livelpool TV", CATEGORY_MAP.get(StaticCategoryDAO.SPORTS_CAT_ID), Collections.singletonList(liverpoolLocation));
        SimpleProduct skyNews = new SimpleProduct(SKY_NEWS_ID, "Sky News", CATEGORY_MAP.get(StaticCategoryDAO.NEWS_CAT_ID));
        SimpleProduct skySports = new SimpleProduct(SKY_SPORTS_ID, "Sky Sports", CATEGORY_MAP.get(StaticCategoryDAO.SPORTS_NEWS_CAT_ID));

        PRODUCT_MAP.putIfAbsent(arsenalTV.getID(), arsenalTV);
        PRODUCT_MAP.putIfAbsent(chelseaTV.getID(), chelseaTV);
        PRODUCT_MAP.putIfAbsent(liverpoolTV.getID(), liverpoolTV);
        PRODUCT_MAP.putIfAbsent(skyNews.getID(), skyNews);
        PRODUCT_MAP.putIfAbsent(skySports.getID(), skySports);

        LOCATION_TO_PRODUCTS_MAP.putIfAbsent(londonLocation.getId(), Arrays.asList(arsenalTV.getID(), chelseaTV.getID(), skyNews.getID(), skySports.getID()));
        LOCATION_TO_PRODUCTS_MAP.putIfAbsent(liverpoolLocation.getId(), Arrays.asList(liverpoolTV.getID(), skyNews.getID(), skySports.getID()));
    }

    private final static Catalogue CATALOGUE = new SimpleCatalogue(new ArrayList<>(PRODUCT_MAP.values()));

    public static Catalogue getCatalogue() {
        return CATALOGUE;
    }

    public static Catalogue getCatalogueByLocation(SkyId locationID) {
        List<SkyId> productsIDs = LOCATION_TO_PRODUCTS_MAP.get(locationID);
        if (productsIDs == null) return null;
        List<Product> products = new ArrayList<>();
        for (SkyId id : productsIDs) {
            products.add(PRODUCT_MAP.get(id));
        }
        return new SimpleCatalogue(products);
    }

    public static Product getProductById(SkyId productId){
        return PRODUCT_MAP.get(productId);
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
