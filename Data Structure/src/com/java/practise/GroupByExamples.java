package com.java.practise;

import java.util.*;

import static java.util.stream.Collectors.*;

public class GroupByExamples {

    public static void main(String[] args) {

        List<BlogPost> posts;

        BlogPost post1 = new BlogPost("Mumbai", "John", BlogPostType.GUIDE, 5);
        BlogPost post2 = new BlogPost("Pune", "William", BlogPostType.NEWS, 7);
        BlogPost post3 = new BlogPost("Solapur", "Kevin", BlogPostType.REVIEW, 9);
        BlogPost post4 = new BlogPost("Chennai", "John", BlogPostType.GUIDE, 2);
        BlogPost post5 = new BlogPost("Hyderabad", "Abecca", BlogPostType.NEWS, 11);

        posts = Arrays.asList(post1, post2, post3, post4, post5);

        int task = 3;

        switch (task) {
            case 1:
                //print all blogposts
                printAllBlogPosts(posts);
                break;
            case 2:
                //To group the blog posts in the blog post list by their type
                groupByBlogPostType(posts);
                break;

            case 3:
                //To group the List of BlogPosts first by author and then by type
                groupByFirstAuthorAndThenByType(posts);
                break;

            case 4:
                //To calculate the total sum of likes for each type
                calculateTotalSumOfEachType(posts);
                break;

            case 5:
                //To get the blog post with the maximum number of likes
                getBlogPostsWithMaxNumberOfLikes(posts);
                break;

            case 6:
                //Group by name and get count of such elements
                groupByNameAndGetCount(posts);
                break;

            default:
                printAllBlogPosts(posts);
        }
    }

    private static void groupByNameAndGetCount(List<BlogPost> posts) {

    Map<String,Long> authorCount = posts.stream().collect(groupingBy(BlogPost::getAuthor, counting()));
    System.out.println(authorCount);
    }

    private static void getBlogPostsWithMaxNumberOfLikes(List<BlogPost> posts) {

    Map<BlogPostType, Optional<BlogPost>> postTypeByMaxLikes = posts.stream().collect(groupingBy(BlogPost::getType , maxBy(Comparator.comparingInt(BlogPost::getLikes))));
    System.out.println(postTypeByMaxLikes);
    }

    private static void calculateTotalSumOfEachType(List<BlogPost> posts) {
    Map<BlogPostType , Integer> typeAndLikes =  posts.stream().collect(groupingBy(BlogPost::getType, summingInt(BlogPost::getLikes)));
    System.out.println(typeAndLikes);
    }

    private static void groupByFirstAuthorAndThenByType(List<BlogPost> posts) {

    Map<String,Map<BlogPostType,List<BlogPost>>> blogPostsByAuthor = posts.stream().collect(groupingBy(BlogPost::getAuthor,groupingBy(BlogPost::getType)));
    System.out.println(blogPostsByAuthor);
    }

    private static void groupByBlogPostType(List<BlogPost> posts) {

    Map<BlogPostType,List<BlogPost>> postsByType = posts.stream().collect(groupingBy(BlogPost::getType));
    System.out.println(postsByType);
    }

    private static void printAllBlogPosts(List<BlogPost> posts) {
        posts.forEach(System.out::println);
    }

}
