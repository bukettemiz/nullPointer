package SeleniumLocators;

public class XPATHLocators {
    /*
    it is an advance way of finding the element. Unlike others, this one is more useful and professional since
    it has many functions to be able to find the unique element.

    INTERVIEW QUESTIONS:
    1-What is the difference between radioButton and CheckBox?
    --> The radio button can be selected one it means you can choose only one option(male or female)
    -->CheckBox can be selected multiple options.It means there is no limitations for selecting the boxes(Manual,

    2-What type of Xpath do you know and which one do you use in your automation framework?
    there are two types of XPATH:

    1)Absolute XPATH: It goes from all the way parent(html) and all the way child(div, a, input)
    -->/html/body/div[2]/div/div/h3    SIDE NOTE:Absolute must start from html
    -->Earth/USA/IL/Chicago/DesPlains/2200/Codefish
    2)Relative XPATH:it might go to parent to child but not necessary to all the way(html).
    It can also directly go to thechild to find the element.
     -->//h3 SIDE NOTE:You can directly go to
    -->Either say Codefish or //2200//Codefish

    3-What is the difference between Absolute and relative Xpath?
    -->ABSOLUTE:Starts with all the way parent to child (html-->child)
         :it always with single slash
    -->RELATIVE: Starts with either directly to child or parent-child
         :It always starts with double slash

    XPATH LOCATOR:
    1- //TAGNAME [@Attribute-'AttributeValue"); MOST USAGE (PLEASE KNOW THIS LIKE YOUR NAME) -->ALL ATTRIBUTES
    2- / /TAGNAME (contains (text (), 'textValue')]: This one looks for contains not $100 match up --›Used for Text
    3- / /TAGNAME [. = 'textValue']; -->This one looks for $100 match up text.
--›Used for Text



     */
}
