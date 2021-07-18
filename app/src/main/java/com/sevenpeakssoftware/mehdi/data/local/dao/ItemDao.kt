package com.sevenpeakssoftware.mehdi.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.sevenpeakssoftware.mehdi.domain.model.Item
import com.sevenpeakssoftware.mehdi.domain.model.ItemEntity

@Dao
interface ItemDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertItem(items: ItemEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertItems(items: List<ItemEntity>)
}