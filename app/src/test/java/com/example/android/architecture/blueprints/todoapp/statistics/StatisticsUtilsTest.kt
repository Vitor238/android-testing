package com.example.android.architecture.blueprints.todoapp.statistics

import com.example.android.architecture.blueprints.todoapp.data.Task
import org.hamcrest.CoreMatchers.`is`
import org.junit.Assert.*
import org.junit.Test

class StatisticsUtilsTest{

    // If there's no completed task and one active task,
    // then there are 100% active tasks and 0% completed tasks.

    @Test
    fun getActiveAndCompletedStats_noCompleted_returnsZeroHundred(){
        //GIVEN a list of tasks with a single, active, task
        val tasks = listOf<Task>(
            Task("title","description",isCompleted = false)
        )

        //WHEN you call getActiveAndCompleteStats
        val result = getActiveAndCompletedStats(tasks)

        //THEN there are 0% completed tasks and 100% active tasks
        assertThat(result.completedTasksPercent, `is`(0f))
        assertThat(result.activeTasksPercent, `is`(100f))
    }


    //If there's 2 completed tasks and 3 active tasks,
    // then there are 40% percent completed tasks and 60% active tasks.


    @Test
    fun getActiveAndCompletedStats_both_returnsFortySixty(){
        val tasks = listOf<Task>(
            Task("title","description",isCompleted = true),
            Task("title","description",isCompleted = true),
            Task("title","description",isCompleted = false),
            Task("title","description",isCompleted = false),
            Task("title","description",isCompleted = false)
        )

        val result = getActiveAndCompletedStats(tasks)

        assertEquals(40f,result.completedTasksPercent)
        assertEquals(60f,result.activeTasksPercent)
    }


    @Test
    fun getActiveAndCompletedStats_empty_returnsZeros(){
        val tasks = listOf<Task>()

        val result = getActiveAndCompletedStats(tasks)

        assertEquals(0f,result.completedTasksPercent)
        assertEquals(0f,result.activeTasksPercent)
    }

    @Test
    fun getActiveAndCompletedStats_null_returnsZeros(){
        val tasks = null

        val result = getActiveAndCompletedStats(tasks)

        assertEquals(0f,result.completedTasksPercent)
        assertEquals(0f,result.activeTasksPercent)
    }
}