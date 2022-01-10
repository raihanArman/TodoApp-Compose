package com.raihanarman.todoapp_compose.di

import android.app.Application
import androidx.room.Room
import com.raihanarman.todoapp_compose.data.TodoDatabase
import com.raihanarman.todoapp_compose.data.TodoRepository
import com.raihanarman.todoapp_compose.data.TodoRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideTodoDatabase(app: Application): TodoDatabase{
        return Room.databaseBuilder(
            app,
            TodoDatabase::class.java,
            "todo_app"
        ).build()
    }

    @Provides
    @Singleton
    fun provideTodoRepository(db: TodoDatabase): TodoRepository{
        return TodoRepositoryImpl(db.dao)
    }

}