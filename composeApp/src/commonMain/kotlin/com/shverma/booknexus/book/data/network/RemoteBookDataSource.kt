package com.shverma.booknexus.book.data.network

import com.shverma.booknexus.book.data.dto.SearchResponseDto
import com.shverma.booknexus.core.domain.DataError
import com.shverma.booknexus.core.domain.Result

interface RemoteBookDataSource {
    suspend fun searchBooks(
        query: String,
        resultLimit: Int? = null
    ): Result<SearchResponseDto, DataError.Remote>
}