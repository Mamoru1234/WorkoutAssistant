package com.example.workoutassistant.data

import androidx.annotation.StringRes
import com.example.workoutassistant.R
import java.time.Duration
import java.util.*

enum class ExerciseType {
    Timing,
    Countable,
    DoubleCountable
}

data class ExerciseDuration(
    val time: Duration,
    val count: Int
) {
    fun increase(type: ExerciseType): ExerciseDuration {
        return when(type) {
            ExerciseType.Countable -> this.copy(count = this.count + 1)
            ExerciseType.Timing -> this.copy(time = this.time.plus(Duration.ofSeconds(10)))
            ExerciseType.DoubleCountable -> this.copy(count = this.count + 2)
        }
    }

    fun format(type: ExerciseType): String {
        return when(type) {
            ExerciseType.Timing -> this.time.seconds.toString()
            ExerciseType.DoubleCountable -> (this.count / 2).toString()
            ExerciseType.Countable -> this.count.toString()
        }
    }

    fun decrease(type: ExerciseType): ExerciseDuration {
        return when(type) {
            ExerciseType.Countable -> {
                if (this.count > 1) {
                    return this.copy(count = this.count - 1)
                }
                return this
            }
            ExerciseType.Timing -> this.copy(time = this.time.minus(Duration.ofSeconds(10)))
            ExerciseType.DoubleCountable -> {
                if (this.count > 2) {
                    return this.copy(count = this.count - 2)
                }
                return this
            }
        }
    }
    companion object {
        fun fromCount(count: Int): ExerciseDuration {
            return ExerciseDuration(Duration.ofSeconds(0), count)
        }
        fun fromTime(duration: Duration): ExerciseDuration {
            return ExerciseDuration(duration, 0)
        }
    }
}

data class ExerciseData(
    val id: UUID,
    @StringRes val title: Int,
    val type: ExerciseType,
    val defaultDuration: ExerciseDuration
)

fun getAllExercises(): List<ExerciseData> {
    return listOf(
        ExerciseData(
            UUID.fromString("f213779c-6cdd-47ea-9cd6-9f8fa74ea367"),
            R.string.push_up,
            ExerciseType.Countable,
            ExerciseDuration.fromCount(10),
        ),
        ExerciseData(
            UUID.fromString("b69aba66-8831-4231-8597-f3393f6dc388"),
            R.string.backward_lunge,
            ExerciseType.DoubleCountable,
            ExerciseDuration.fromCount(20),
        ),
        ExerciseData(
            UUID.fromString("4cd4f166-f5a7-4b7b-89d8-e9846c75b984"),
            R.string.leg_raises,
            ExerciseType.Countable,
            ExerciseDuration.fromCount(10),
        ),
        ExerciseData(
            UUID.fromString("bf0b3ec7-f78a-47da-8aee-33ede08e71eb"),
            R.string.jumping_jacks,
            ExerciseType.Timing,
            ExerciseDuration.fromTime(Duration.ofSeconds(30))
        )
    )
}
