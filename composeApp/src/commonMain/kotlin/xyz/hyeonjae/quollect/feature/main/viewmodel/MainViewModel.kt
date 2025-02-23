package xyz.hyeonjae.quollect.feature.main.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.postgrest.from
import io.github.jan.supabase.postgrest.query.Columns
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import xyz.hyeonjae.quollect.dto.QuoteDto
import xyz.hyeonjae.quollect.feature.main.viewdata.mapper.QuoteViewDataMapper

class MainViewModel(
    private val supabaseClient: SupabaseClient
) : ViewModel() {
    private var page: Int = 0
    private var isLoading: Boolean = false
    private val quoteDtos = MutableStateFlow<List<QuoteDto>>(emptyList())
    val quotes = quoteDtos.map { dtos ->
        dtos.map { QuoteViewDataMapper().viewData(it) }
    }

    fun reset() {
        quoteDtos.value = emptyList()
        page = 0
        isLoading = false
        getQuotes(page)
    }

    fun loadMore() {
        page += 1
        getQuotes(page)
    }

    private fun getQuotes(page: Int) {
        if (isLoading) return

        isLoading = true
        viewModelScope.launch {
            val sizePerPage = 3
            val from: Long = (page * sizePerPage).toLong()
            val to: Long = ((page + 1) * sizePerPage - 1).toLong()
            val selectedValues = supabaseClient
                .from("quotes")
                .select(columns = Columns.raw("*, speakers(*)")) {
                    range(from, to)
                }

            val dtos = selectedValues.decodeList<QuoteDto>().toMutableList()
            quoteDtos.value += dtos
            isLoading = false
        }
    }
}