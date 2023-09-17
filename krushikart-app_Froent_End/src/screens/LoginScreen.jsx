import React, { useState } from 'react'
import { Container } from 'react-bootstrap'
import { Navigate, useNavigate } from 'react-router-dom'
import base_url from '../api/bootapi'
import httpClient from '../http-common'
import { toast, Toaster } from 'react-hot-toast'
import { useAuth } from '../context/auth'

const Login = () => {
  const [email, setEmail] = useState('')
  const [password, setPassword] = useState('')
  const [auth, setAuth] = useAuth()

  const navigate = useNavigate()

  const handleSubmit = async (e) => {
    e.preventDefault()
    try {
      const res = await httpClient.post(`${base_url}/api/auth/signin`, {
        email,
        password,
      })

      if (res.status === 200) {
        toast.success('Login successfully')
        
        navigate('/')
        console.log(res.data)
        setAuth({
          ...auth,
          user: res.data.user,
          token: res.data.jwt,
        })
        localStorage.setItem('auth', JSON.stringify(res.data))
        localStorage.setItem('user', res.data.jwt)
        localStorage.setItem('loggedIn', 'true')
        localStorage.setItem(
          'userName',
          res.data.user.firstName + ' ' + res.data.user.lastName,
        )
        // window.location.reload()
      } else {
        toast.error('Something went wrong...')
      }
    } catch (error) {}
  }

  return (
    <div>
      <div className="row mb-4 ">
        <div className="col-4">
          <div className="my-4">
            <h1>Login : </h1>
          </div>
          <form onSubmit={handleSubmit}>
            {/* Email input */}
            <div className="form-outline mb-4">
              <input
                type="email"
                value={email}
                onChange={(e) => setEmail(e.target.value)}
                id="email"
                className="form-control"
                placeholder="Entert the Email Address"
              />
            </div>

            {/* Password input */}
            <div className="form-outline mb-4">
              <input
                type="password"
                value={password}
                onChange={(e) => setPassword(e.target.value)}
                id="password"
                className="form-control"
                placeholder="Entert the Password"
              />
            </div>

            <hr />

            {/* Submit button */}
            {/* <div className="text-center">
          <button type="submit" className="btn btn-primary btn-block mb-4 ">
            Login
          </button>
        </div> */}

            <div className="row mb-4">
              <div className="col ">
                <div className="text-left">
                  <div className="form-outline">
                    <button
                      type="submit"
                      className="btn btn-primary btn-block mb-4 "
                    >
                      Login
                    </button>
                  </div>
                </div>
              </div>
              <div className="col">
                <div className="form-outline">
                  <div className="text-center">
                    <button
                      type="submit"
                      className="btn btn-primary btn-block mb-4 "
                      onClick={() => {
                        navigate('/api/user/forgotpassword')
                      }}
                    >
                      Forgot Password
                    </button>
                  </div>
                </div>
              </div>
            </div>
          </form>
        </div>
      </div>
    </div>
  )
}

export default Login
