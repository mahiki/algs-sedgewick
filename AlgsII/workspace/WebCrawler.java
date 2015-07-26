/** this is a working web crawler in Java
 *  dependencies are in the princeton algs jar files
 *  Queue, StdOut, In, Pattern, Matcher
 *
 *  needs a method to output the SET marked
 **/

Queue<String> queue = new Queue<String>();
SET<String> marked = new SET<String>();

String root = "http://www.princeton.edu";
queue.enqueue(root);
marked.add(root);

while (!queue.isEmpty()) {
  String v = queue.dequeue();
  StdOut.println(v);
  In in = new In(v);
  String input = in.readAll();

  String regexp = "http://(\\w+\\.)*(\\w+)";
  Pattern pattern = Pattern.compile(regexp);
  Matcher matcher = pattern.matcher(input);

  while (matcher.find()) {
    String w = matcher.group();
    if (!marked.contains(w)) {
      marked.add(w);
      queue.enqueue(w);
    }
  }
}