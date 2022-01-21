package mehdiparsaei.simonsvoss.assignment.ui

import androidx.lifecycle.ViewModel
import mehdiparsaei.simonsvoss.assignment.domain.usecase.GetLocksUseCase
import javax.inject.Inject

class MainViewModel @Inject constructor(private  val getLocksUseCase: GetLocksUseCase):ViewModel() {
}