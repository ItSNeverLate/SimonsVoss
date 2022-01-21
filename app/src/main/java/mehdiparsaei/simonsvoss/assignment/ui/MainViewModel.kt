package mehdiparsaei.simonsvoss.assignment.ui

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import mehdiparsaei.simonsvoss.assignment.domain.usecase.GetLocksUseCase
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getLocksUseCase: GetLocksUseCase,
    private val state: SavedStateHandle,
) : ViewModel() {

    private val searchQuery = state.getLiveData("searchQuery", "")

    val locksFlow = getLocksUseCase(searchQuery.value.toString())
}