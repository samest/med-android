/*
 * This file is part of Grocy Android.
 *
 * Grocy Android is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Grocy Android is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Grocy Android. If not, see http://www.gnu.org/licenses/.
 *
 * Copyright (c) 2020-2024 by Patrick Zedler and Dominic Zedler
 * Copyright (c) 2024-2026 by Patrick Zedler
 */

package xyz.zedler.patrick.med.database;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.schedulers.Schedulers;
import xyz.zedler.patrick.med.dao.ChoreDao;
import xyz.zedler.patrick.med.dao.ChoreEntryDao;
import xyz.zedler.patrick.med.dao.LocationDao;
import xyz.zedler.patrick.med.dao.MealPlanEntryDao;
import xyz.zedler.patrick.med.dao.MealPlanSectionDao;
import xyz.zedler.patrick.med.dao.MissingItemDao;
import xyz.zedler.patrick.med.dao.PendingProductBarcodeDao;
import xyz.zedler.patrick.med.dao.PendingProductDao;
import xyz.zedler.patrick.med.dao.ProductAveragePriceDao;
import xyz.zedler.patrick.med.dao.ProductBarcodeDao;
import xyz.zedler.patrick.med.dao.ProductDao;
import xyz.zedler.patrick.med.dao.ProductGroupDao;
import xyz.zedler.patrick.med.dao.ProductLastPurchasedDao;
import xyz.zedler.patrick.med.dao.QuantityUnitConversionDao;
import xyz.zedler.patrick.med.dao.QuantityUnitConversionResolvedDao;
import xyz.zedler.patrick.med.dao.QuantityUnitDao;
import xyz.zedler.patrick.med.dao.RecipeDao;
import xyz.zedler.patrick.med.dao.RecipeFulfillmentDao;
import xyz.zedler.patrick.med.dao.RecipeNestingDao;
import xyz.zedler.patrick.med.dao.RecipePositionDao;
import xyz.zedler.patrick.med.dao.RecipePositionResolvedDao;
import xyz.zedler.patrick.med.dao.ServerDao;
import xyz.zedler.patrick.med.dao.ShoppingListDao;
import xyz.zedler.patrick.med.dao.ShoppingListItemDao;
import xyz.zedler.patrick.med.dao.StockEntryDao;
import xyz.zedler.patrick.med.dao.StockItemDao;
import xyz.zedler.patrick.med.dao.StockLocationDao;
import xyz.zedler.patrick.med.dao.StoreDao;
import xyz.zedler.patrick.med.dao.StoredPurchaseDao;
import xyz.zedler.patrick.med.dao.TaskCategoryDao;
import xyz.zedler.patrick.med.dao.TaskDao;
import xyz.zedler.patrick.med.dao.UserDao;
import xyz.zedler.patrick.med.dao.UserfieldDao;
import xyz.zedler.patrick.med.dao.VolatileItemDao;
import xyz.zedler.patrick.med.model.Chore;
import xyz.zedler.patrick.med.model.ChoreEntry;
import xyz.zedler.patrick.med.model.Location;
import xyz.zedler.patrick.med.model.MealPlanEntry;
import xyz.zedler.patrick.med.model.MealPlanSection;
import xyz.zedler.patrick.med.model.MissingItem;
import xyz.zedler.patrick.med.model.PendingProduct;
import xyz.zedler.patrick.med.model.PendingProductBarcode;
import xyz.zedler.patrick.med.model.Product;
import xyz.zedler.patrick.med.model.ProductAveragePrice;
import xyz.zedler.patrick.med.model.ProductBarcode;
import xyz.zedler.patrick.med.model.ProductGroup;
import xyz.zedler.patrick.med.model.ProductLastPurchased;
import xyz.zedler.patrick.med.model.QuantityUnit;
import xyz.zedler.patrick.med.model.QuantityUnitConversion;
import xyz.zedler.patrick.med.model.QuantityUnitConversionResolved;
import xyz.zedler.patrick.med.model.Recipe;
import xyz.zedler.patrick.med.model.RecipeFulfillment;
import xyz.zedler.patrick.med.model.RecipeNesting;
import xyz.zedler.patrick.med.model.RecipeNestingResolved;
import xyz.zedler.patrick.med.model.RecipePosition;
import xyz.zedler.patrick.med.model.RecipePositionResolved;
import xyz.zedler.patrick.med.model.Server;
import xyz.zedler.patrick.med.model.ShoppingList;
import xyz.zedler.patrick.med.model.ShoppingListItem;
import xyz.zedler.patrick.med.model.StockEntry;
import xyz.zedler.patrick.med.model.StockItem;
import xyz.zedler.patrick.med.model.StockLocation;
import xyz.zedler.patrick.med.model.Store;
import xyz.zedler.patrick.med.model.StoredPurchase;
import xyz.zedler.patrick.med.model.Task;
import xyz.zedler.patrick.med.model.TaskCategory;
import xyz.zedler.patrick.med.model.User;
import xyz.zedler.patrick.med.model.Userfield;
import xyz.zedler.patrick.med.model.VolatileItem;
import xyz.zedler.patrick.med.repository.MainRepository.OnVersionListener;

@Database(
    entities = {
        ShoppingList.class,
        ShoppingListItem.class,
        Product.class,
        ProductGroup.class,
        QuantityUnit.class,
        Store.class,
        Location.class,
        VolatileItem.class,
        MissingItem.class,
        QuantityUnitConversion.class,
        QuantityUnitConversionResolved.class,
        ProductBarcode.class,
        StockItem.class,
        StockLocation.class,
        Task.class,
        TaskCategory.class,
        ProductLastPurchased.class,
        ProductAveragePrice.class,
        PendingProduct.class,
        PendingProductBarcode.class,
        StoredPurchase.class,
        User.class,
        Chore.class,
        ChoreEntry.class,
        StockEntry.class,
        Server.class,
        Recipe.class,
        RecipeFulfillment.class,
        RecipePosition.class,
        RecipePositionResolved.class,
        RecipeNesting.class,
        MealPlanEntry.class,
        MealPlanSection.class,
        Userfield.class
    },
    views = {
        RecipeNestingResolved.class
    },
    version = 54
)
@TypeConverters({Converters.class})
public abstract class AppDatabase extends RoomDatabase {

  private static AppDatabase INSTANCE;

  public abstract ShoppingListDao shoppingListDao();

  public abstract ShoppingListItemDao shoppingListItemDao();

  public abstract ProductDao productDao();

  public abstract ProductGroupDao productGroupDao();

  public abstract QuantityUnitDao quantityUnitDao();

  public abstract StoreDao storeDao();

  public abstract LocationDao locationDao();

  public abstract VolatileItemDao volatileItemDao();

  public abstract MissingItemDao missingItemDao();

  public abstract QuantityUnitConversionDao quantityUnitConversionDao();

  public abstract QuantityUnitConversionResolvedDao quantityUnitConversionResolvedDao();

  public abstract ProductBarcodeDao productBarcodeDao();

  public abstract StockItemDao stockItemDao();

  public abstract StockLocationDao stockLocationDao();

  public abstract TaskDao taskDao();

  public abstract TaskCategoryDao taskCategoryDao();

  public abstract ProductLastPurchasedDao productLastPurchasedDao();

  public abstract ProductAveragePriceDao productAveragePriceDao();

  public abstract PendingProductDao pendingProductDao();

  public abstract PendingProductBarcodeDao pendingProductBarcodeDao();

  public abstract StoredPurchaseDao storedPurchaseDao();

  public abstract UserDao userDao();

  public abstract ChoreDao choreDao();

  public abstract ChoreEntryDao choreEntryDao();

  public abstract RecipeDao recipeDao();

  public abstract RecipeFulfillmentDao recipeFulfillmentDao();

  public abstract RecipePositionDao recipePositionDao();

  public abstract RecipePositionResolvedDao recipePositionResolvedDao();

  public abstract RecipeNestingDao recipeNestingDao();

  public abstract MealPlanEntryDao mealPlanEntryDao();

  public abstract MealPlanSectionDao mealPlanSectionDao();

  public abstract StockEntryDao stockEntryDao();

  public abstract UserfieldDao userfieldDao();

  public abstract ServerDao serverDao();

  public static AppDatabase getAppDatabase(Context context) {
    if (INSTANCE == null) {
      INSTANCE = Room.databaseBuilder(
          context.getApplicationContext(),
          AppDatabase.class,
          "app_database"
      ).fallbackToDestructiveMigration().build();
    }
    return INSTANCE;
  }

  public static void destroyInstance() {
    INSTANCE = null;
  }

  public void getVersion(OnVersionListener versionListener) {
    Single.fromCallable(() -> getOpenHelper().getReadableDatabase().getVersion())
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .doOnSuccess(versionListener::onVersion)
        .onErrorComplete()
        .subscribe();
  }
}
