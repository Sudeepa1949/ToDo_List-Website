import axios from 'axios';
import React, { useEffect, useState } from 'react';
import { Link } from 'react-router-dom/cjs/react-router-dom.min';
import image1 from "./image1.jpg";
export default function Landing({isAuthenticated, setIsAuthenticated}) {
  const [message, setMessage] = useState('')
  const [numberAllTodoNotCompleted, setNumberAllTodoNotCompleted] = useState(0);
  const [numberAllTodo, setNumberAllTodo] = useState(0);
  const [errorMessage, setErrorMessage] = useState('');

  const showErrorMessage = () => {
    if(errorMessage === ''){
      return <div></div>
    }

    return <div className="alert alert-danger" role="alert">
      {errorMessage}
    </div>
  }

  useEffect(() => {
    async function getAndSetNumberAllTodo() {
      try{
        const response = await axios.get('http://localhost:3001/api/todo/count', {
          headers: {
            'Authorization': `Bearer ${sessionStorage.getItem('token')}`,
          }
        });
        setNumberAllTodo(response.data.count);
      } catch (error) {
        setMessage('');
        if (error.response) {
          setErrorMessage(error.response.data.message);
        } else {
          setErrorMessage('Error: something happened');
        }
      }
    }

    async function getAndSetNumberAllTodoNotCompleted() {
      try{
        const response = await axios.get('http://localhost:3001/api/todo/count?isCompleted=false', {
          headers: {
            'Authorization': `Bearer ${sessionStorage.getItem('token')}`,
          }
        });

        setNumberAllTodoNotCompleted(response.data.count);
      } catch (error) {
        setMessage('');
        if (error.response) {
          setErrorMessage(error.response.data.message);
        } else {
          setErrorMessage('Error: something happened');
        }
      }
      
    }
    if(isAuthenticated){
      getAndSetNumberAllTodo();
      getAndSetNumberAllTodoNotCompleted();
    } else {
      setMessage(<p>Please sign in to continue......</p>);  
    }
  }, [isAuthenticated, numberAllTodo, numberAllTodoNotCompleted])

	return (
		<div>
<React.Fragment>
     <header>
         <img src={image1} />
     </header>
 </React.Fragment>
			{/* {message}  */}
		</div>
	)
}