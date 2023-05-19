
/*console.log("Hello World")

console.log(2+2)

let num = 4
console.log(num)
console.log(num*2)

num = 5
console.log(num)

let userName = "Eldho"
console.log(userName)

let radius = 5
const pi = 3.14
let area

radius = 6
area = pi * (radius * radius)
console.log(area)

console.log(typeof area)

let num1 = String(6)
console.log(num1, typeof num1)


let x
console.log(x, typeof x)
x = 8
console.log(x, typeof x)
x = x + ""
console.log(x, typeof x)
x = x - 2
console.log(x, typeof x)
x = !x
console.log(x, typeof x)

let num1 = true
let num2 = true
console.log(num1 + num2)

let num = 4
let x = num++
console.log(x,num)

console.log(Math.pow(3,2))

let name1 = "Pen"
let name2 = "Book"
console.log(name1 > name2)

let x = 7, y = 2, z = 5
let result = x < y && x < z
console.log(result)

let num1 = 3;
let num2 = 4;

let result = num1 > num2;

if(result){
	console.log("num1 is greater");
}
	
else{
	console.log("num2 is greater");
	console.log("yes");
}

console.log("Bye");

let num1 = 9;
let num2 = 4;
let result = num1 + num2;

console.log("The addition of " + num1 + " and " + num2 + " is " + result);

let i = 1;
while(i<=5){
	console.log("Hi");
	i++;
}

do{
	console.log("Hi");
}while(false)

for (let i = 1; i < 10; i++){
	console.log("Hi",i);
}
let box = {
	name:"Eldho",
	age: 23,
	'work experience': 3
}
console.log(box, typeof box, box.name, box['work experience']);

let box = {
	name:"Eldho",
	age:23,
	laptop: {
		brand:"Apple",
		model:"Macbook Pro M2"
	}
}
delete box.age;
console.log(box.laptop?.model);
console.log(box);

for(let key in box){
	console.log(key,box[key])
}

function greet(user){
	return `Hala ${user}`
}

let str = greet("Real Madrid");
console.log(str);

let add = function(num1,num2){
			return num1+num2
}
let sum = add;
console.log(sum(2,3));

let greet = () => {
	console.log("hello");
	return 1
}
greet();

let add = (num1,num2) => num1 + num2

console.log(add(2,3));

let laptop = {
	cpu:"i9",
	ram:16,
	brand:"HP",
	getConfig: function(){
		console.log(this.cpu);
	}
}
laptop.getConfig();

function box(name,tech){
	this.name = name;
	this.tech = tech;
}

let box1 = new box("eldho","HP");
console.log(box1);

let values = [5,7,8];
values.push(9);

console.log(values);
console.log(values[2]);

let names = ["Eldho","Babu","Ramesh"];
names[3] = "Sumesh";
console.log(names);

let data = ["Eldho", 24, {tech:"JS"}, function(){console.log("Hello World")}];
console.log(data);
data[3]();

let data = [5,7,8,9];
console.log(data.push(2));
console.log(data.pop());
console.log(data.shift());
console.log(data.unshift(1));
console.log(data.splice(3,2,11));
console.log(data)

let num = [];

num[0] = 5;
num[99] = 9;

for(let x of num){
	console.log(x);
}

for(let key in num){
	console.log(key);
}

let nums = [5,7,2,4];
let [a,b,,d] = nums;
[a,b,d] = [d,b,a]
console.log(a,b,d);

let words = "My name is Eldho".split(" ");
let [a,b,...c] = words;
console.log(c,a);

let nums = [42, 51, 24, 98, 65, 12];
console.log(nums.filter(n => n%2===0));
nums.forEach((n) => {
	console.log(n);
});

let nums = [42, 51, 24, 98, 65, 12];

nums.filter( n => n%2===0)
	.map( n => n*2)
	.forEach( n => {
		console.log(n);
	});

let nums = [42, 51, 24, 98, 65, 12];

let result = nums.filter( n => n%2===0)
	.map( n => n*2)
	.reduce((a,b) => a+b);
	
console.log(result);

let nums = new Set("bookkeeper");
console.log(nums.has("k"))
console.log(nums);
nums.forEach(value => console.log(value));
*/

let map = new Map();
map.set("Eldho","Java");
map.set("Kiran", "Android");
map.set("Chirag", "ML");
console.log(map.has("Kiran"));
console.log(map.keys());
console.log(map.get("Chirag"));
for(let [k,v] of map){
	console.log(k,v);
}