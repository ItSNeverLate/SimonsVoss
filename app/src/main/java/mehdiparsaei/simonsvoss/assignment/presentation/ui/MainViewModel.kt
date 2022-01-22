package mehdiparsaei.simonsvoss.assignment.presentation.ui

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flatMapLatest
import mehdiparsaei.simonsvoss.assignment.domain.usecase.GetLocksUseCase
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(getLocksUseCase: GetLocksUseCase) : ViewModel() {

    val searchQuery = MutableStateFlow("")

    val locksFlow = searchQuery.flatMapLatest { searchQuery ->
        getLocksUseCase(searchQuery)
    }
}