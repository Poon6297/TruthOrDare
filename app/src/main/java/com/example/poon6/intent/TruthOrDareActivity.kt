package com.example.poon6.intent

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.truth_or_dare.*
import kotlin.math.floor

class TruthOrDareActivity : AppCompatActivity() {

    val EASY = 25
    val MIDDLE = 33
    val EXCITING = 40
    val DARE = 43

    var noOfPeople = 0
    val truthQuestionBank = arrayOf(

            // Easy
            "Can you remember the names of all the people in this room？",
            "What’s your major?",
            "What country are you from？",
            "Your age? ",
            "Do you like your major?",
            "What's the name of the fifth person on your left？",
            "What's the name of the fifth person on your left？",
            "What's the name of the sixth person on your left?",
            "What's the name of the third person on your right?",
            "What's the name of the fourth person on your right?",
            "What's the name of the seventh person on your right?",
            "Do you enjoy your university life?",
            "What’s your hobby?",
            "What’s your favorite sport?",
            "Do you watch drama?",
            "Do you like watching movies?",
            "What’s your favorite movie?",
            "What’s your favorite book?",
            "Who is your favorite writer?",
            "What’s your favorite subject in NTU?",
            "What was your least favorite subject？",
            "Do you often go to library?",
            "Which do you prefer? Studying in the dormitory or in the study room？",
            "Do you like excitement or a person？",
            "Share an embarrassing thing on you",


            // Middle
            "Who is your favorite? Mom or Dad?",
            "Would you trade your sibling in for a million dollars?",
            "Would you trade in your dog for a million dollars?",
            "Would you rather lose your organs forever or gain 200 pounds?",
            "Would you choose to save 100 people without anyone knowing about it or not save them but have everyone praise you for it?",
            "If you could only hear one song for the rest of your life, what would it be?",
            "If you can predict the future, what do you most want to see?",
            "If you can predict the future, what do you least want to see?",
            "Which is more important for you? Relationship or friendship?",
            "Chicken or the egg",
            "If you can go back to the past, what do you want to do most?",
            "What was the last thing you searched for on your phone?",
            "Do you cover your eyes during a scary part in a movie?",
            "Do you sing in the shower?",
            "Do you ever talk to yourself in the mirror?",
            "What would be in your web history that you’d be embarrassed if someone saw?",
            "Who do you think is the best dressed person in this room?",
            "Do you sleep with a stuffed animal?",
            "If you could suddenly become invisible, what would you do?",
            "Have you ever waved at someone thinking they saw you when really they didn't? ",
            "What did you do when you realized it?",
            "Would you wear your shirt inside out for a whole day if someone paid you \$100?",
            "What is the most childish thing that you still do?",
            "What app on your phone do you waste the most time on?",
            "Have you ever pretended to be sick to get out of something? If so, what was it?",
            "What is the most food you’ve eaten in a single sitting?",
            "Would you have voted for or against Trump?",
            "Are you scared of the dark?",
            "If you were home by yourself all day, what would you do?",
            "How many selfies do you take a day?",
            "What is something you’ve done to try to be ‘cooler’?",
            "Do you like hanging out with your parents?",
            "Have you ever got caught doing something you shouldn’t?",
            "You have to delete every app on your except for five. Name the five you would keep",


            // Exciting
            "Of the people in this room, who do you want to trade lives with?",
            "Who do you think is the worst dressed person in this room?",
            "What's the first thing you would do if you woke up one day as the opposite sex?",
            "What are some things you think about when sitting on the toilet?",
            "Have you ever practiced kissing in a mirror?",
            "What is your worst habit?",
            "What was your most embarrassing moment in public?",
            "Have you ever tried to take a sexy picture of yourself?",
            "Do you drool in your sleep?",
            "Do you talk in your sleep?",
            "Who is your secret crush?",
            "Who do you like the most in this room and why?",
            "What does your dream boy or girl look like?",
            "What is your go-to song for the shower?",
            "Who is the sexiest person in this room?",
            "How would you rate your looks on a scale of 1 to 10?",
            "If someone offered you \$1 million dollars to break up with your girlfriend/boyfriend, would you do it?",
            "If you were reborn, what decade would you want to be born in?",
            "If you could go back in time in erase one thing you said or did, what would it be?",
            "Have you ever cried because you missed your parents so much?",
            "Describe the strangest dream you've ever had. ",
            "Have you ever posted something on social media that you regret?",
            "What is your biggest fear?",
            "The world ends next week and you can do anything you want (even if it's illegal). What would you do?",
            "What part of your body do you love and which part do you hate?",
            "What is something that no one else knows about you?",
            "Do you write in a diary?",
            "If you could be reincarnated into anyone's body, who would you want to become?",
            "If you switched genders for the day, what would you do?",
            "What's one food that you will never order at a restaurant?",
            "What's the most useless piece of knowledge you know?",
            "Share your favorite prof or tutor in NTU.",
            "Share a prof or tutor in NTU who you dislike the most.",
            "Do you currently have a crush on anyone?",
            "Describe what your crush looks like.",
            "What is your crush's personality like?",
            "Is there anything about your life you would change?",
            "If you could date anyone in the world, who would you date?",
            "Who is your biggest celebrity crush?",
            "Do you accept premarital sex?")

    val dareQuestionBank = arrayOf(
            "Dance with no music for 1 minute.",
            "Pose an embarrassing position",
            "Play a song on by clapping your hands till someone guesses the song.",
            "Make every person in the group smile, keep going until everyone has cracked a smiled",
            "Let the person to your left draw on your face with a pen.",
            "Attempt to dance for 30 seconds.",
            "Do push-ups until you can’t do any more, wait 5 seconds, and then do one more.",
            "Attempt to do a magic trick.",
            "Imitate a celebrity ",
            "Imitate popular dance until someone can guess the dance you are imitating.",
            "Dance to a song of the group’s choosing.",
            "Imitate an animal",
            "Make a funny face and keep making it for 1 minutes while the game continues.",
            "Imagine something in your room. Now spell it with your nose and keep spelling it with your nose until someone from the group guesses what you are trying spell.",
            "Open a bag of snacks or candy using only your mouth, no hands or feet.",
            "Act like whatever animal someone yells out for the next 1 minute.",
            "Pretend to be a food. Don’t pretend to eat the food, pretend to be the food. ",
            "Keep pretending until someone in the group guesses the food you are.",
            "Sit in a spinning chair and have the group spin you for 30 seconds.",
            "Make an unflattering picture of yourself your Facebook profile picture for at least a day.",
            "Turn off your phone for the rest of the game.",
            "Let someone in the room write whatever they want from your Facebook account.",
            "Imitate the worm.",
            "Hit the shoulder of the left person",
            "Take off your shoes",
            "Do the robot",
            "Do 5 sit ups.",
            "Jog in place very slowly for the next 3 minutes.",
            "Perform a rap for everyone in the room.",
            "Pretend to spin an imaginary hula hoop around your waist for the next 2 minutes.",
            "Streak across the room.",
            "Post a video of you singing and share it on your social media account.",
            "Say the alphabet backwards.",
            "Instead of speaking, you have to sing everything that you want to say for the rest of the game.",
            "Go outside and sing Twinkle, Twinkle Little Star loudly.",
            "Sing a song for 2 minutes, but meow instead of singing the words.",
            "Sit on someone’s lap for 1 minutes.",
            "Stand or jump on one foot for 1 minutes.",
            "Imitate any animal of your choice for several minutes.",
            "Let the person on your left draw a mustache on your skin with a lipstick only.",
            "Let the person on your right put a make up on you blind folded.",
            "Don’t talk for the rest of the game.",
            "Don’t talk to anyone for 30 minutes.")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.truth_or_dare)

        noOfPeople = intent.getIntExtra("noOfPeople", 0)
        val difficulty = intent.getIntExtra("difficulty", 0)

        val randomNumber = randomNumber()
        tv_number.text = randomNumber.toString()


        btn_truth.setOnClickListener {
            val question = randomTruthQuestion(difficulty)
            nextActivity(question)
        }

        btn_dare.setOnClickListener {
            val question = randomDareQuestion()
            nextActivity(question)
        }

        btn_truth_or_dare.setOnClickListener {
            val truthOrDare = Math.random()
            if (truthOrDare < 0.5) {
                val question = randomTruthQuestion(difficulty)
                nextActivity(question)
            } else {
                val question = randomDareQuestion()
                nextActivity(question)
            }
        }
    }

    private fun randomDareQuestion(): String {
        val question = dareQuestionBank.elementAt((Math.random() * DARE).toInt())
        return question
    }

    private fun randomTruthQuestion(difficulty : Int) : String {
        var question = ""

        when (difficulty) {
            1 -> {
                question = truthQuestionBank.elementAt((Math.random() * EASY).toInt())
            }

            2 -> {
                question = truthQuestionBank.elementAt((Math.random() * MIDDLE + EASY).toInt())
            }

            3 -> {
                question = truthQuestionBank.elementAt((Math.random() * EXCITING + MIDDLE + EASY).toInt())
            }
        }

        return question
    }

    private fun nextActivity(question: String) {
        val intent = Intent(this, QuestionActivity::class.java)
        intent.putExtra("noOfPeople", noOfPeople)
        intent.putExtra("question", question)
        startActivity(intent)
    }

    private fun randomNumber() : Int {
        val random = (Math.random() * noOfPeople + 1).toInt()
        return random
    }
}