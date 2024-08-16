import com.example.am_lakestan.data.repo.updateRepository
import com.example.am_lakestan.data.source.UpdateDataSource
import com.example.am_lakestan.data.updates
import io.reactivex.Single

class updateRepositoryImpl(val  remoteDataSource: UpdateDataSource,

                            ) : updateRepository {
    override fun getUpdate(): Single<List<updates>> =remoteDataSource.getUpdate()

}