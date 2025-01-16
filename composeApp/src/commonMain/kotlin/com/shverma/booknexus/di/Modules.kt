package com.shverma.booknexus.di

import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import com.shverma.booknexus.book.data.database.DatabaseFactory
import com.shverma.booknexus.book.data.database.FavoriteBookDatabase
import com.shverma.booknexus.book.data.network.KtorRemoteBookDataSource
import com.shverma.booknexus.book.data.network.RemoteBookDataSource
import com.shverma.booknexus.book.data.repository.DefaultBookRepository
import com.shverma.booknexus.book.domain.BookRepository
import com.shverma.booknexus.book.presentation.SelectedBookViewModel
import com.shverma.booknexus.book.presentation.book_detail.BookDetailViewModel
import com.shverma.booknexus.book.presentation.book_list.BookListViewModel
import com.shverma.booknexus.core.data.HttpClientFactory
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.bind
import org.koin.dsl.module

fun initKoin(config: KoinAppDeclaration? = null) {
    startKoin {
        config?.invoke(this)
        modules(sharedModule, platformModule)
    }
}

expect val platformModule: Module

val sharedModule = module {
    single { HttpClientFactory.create(get()) }
    singleOf(::KtorRemoteBookDataSource).bind<RemoteBookDataSource>()
    singleOf(::DefaultBookRepository).bind<BookRepository>()

    single {
        get<DatabaseFactory>().create().setDriver(BundledSQLiteDriver()).build()
    }

    single { get<FavoriteBookDatabase>().favoriteBookDao }

    viewModelOf(::BookListViewModel)
    viewModelOf(::SelectedBookViewModel)
    viewModelOf(::BookDetailViewModel)
}