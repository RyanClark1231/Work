


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ryan
 */
public class RepoManager {
  private DoublyLinkedList<Repo> repos;
  private int size;
 

  public RepoManager() {
    repos = new DoublyLinkedList<>();
    size = 0;
  }
  
  public void addRepo(String name, long id){
    repos.add(new Repo(name, id));
    size++;
  }
  
  public void removeRepo(String name){
    repos.remove(repos.get(name));
    size--;
  }
  
  public void removeRepo(long id){
    repos.remove(repos.get(id));
    size--;
  }
  
  public DoublyLinkedList<Repo> getRepos(){
    return repos;
  }
  
  public int size(){
    return size;
  }
  
  
}
