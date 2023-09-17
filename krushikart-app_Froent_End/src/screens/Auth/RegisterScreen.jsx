import React, { useState } from 'react'
import { Container } from 'react-bootstrap'
import { Navigate, useNavigate } from 'react-router-dom'
import base_url from '../../api/bootapi'
import httpClient from '../../http-common'
import { toast, Toaster } from 'react-hot-toast'

const Register = () => {
  const [firstName, setFname] = useState('')
  const [lastName, setLname] = useState('')
  const [email, setEmail] = useState('')
  const [password, setPassword] = useState('')
  const [contactNumber, setContactNo] = useState('')
  const [userRole, setUserRole] = useState('')
  const [unit_number, setUnitNo] = useState()
  const [street_number, setStreetNo] = useState()
  const [addressLine1, setAddressl1] = useState('')
  const [addressLine2, setAddressl2] = useState('')
  const [city, setCity] = useState('')
  const [state, setState] = useState('')
  const [postalCode, setPostalCode] = useState()
  const [country, setCountry] = useState('')
  const [age, setAge] = useState()
  const [dob, setDob] = useState('')

  const navigate = useNavigate()

  const address = {
    unit_number,
    street_number,
    addressLine1,
    addressLine2,
    city,
    state,
    postalCode,
    country,
  }

  const handleSubmit = async (e) => {
    e.preventDefault()
    try {
      const res = await httpClient.post(`${base_url}/api/auth/user/signup`, {
        email,
        firstName,
        lastName,
        password,
        dob,
        contactNumber,
        userRole,
        address,
        age,
      })

      if (res.status === 201) {
        toast.success('Register successfully')
        navigate('/api/auth/signin')
      } else {
        toast.error('Something went wrong...')
      }
    } catch (error) {}
  }

  console.log(firstName)

  return (
    <div>
      <div className="my-4">
        <h1>Registration : </h1>
      </div>
      <form onSubmit={handleSubmit}>
        <div className="row mb-4">
          <div className="col">
            <div className="form-outline">
              <input
                type="text"
                value={firstName}
                onChange={(e) => setFname(e.target.value)}
                id="fname"
                className="form-control"
                placeholder="Enter the First Name"
              />
            </div>
          </div>
          <div className="col">
            <div className="form-outline">
              <input
                type="text"
                value={lastName}
                onChange={(e) => setLname(e.target.value)}
                id="lname"
                className="form-control"
                placeholder="Enter the Last Name"
              />
            </div>
          </div>
        </div>

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

        {/* contact number input */}
        <div className="form-outline mb-4">
          <input
            type="text"
            value={contactNumber}
            onChange={(e) => setContactNo(e.target.value)}
            id="contactno"
            className="form-control"
            placeholder="Entert the Contact Number"
          />
        </div>

        {/* Select user role */}
        <div className="form-outline mb-4">
          <select
            className="form-select"
            aria-label="Default select example"
            value={userRole}
            onChange={(e) => setUserRole(e.target.value)}
          >
            <option defaultValue>Select User Role</option>
            <option value="ROLE_ADMIN">Admin</option>
            <option value="ROLE_CUSTOMER">User</option>
            <option value="ROLE_SELLER">Seller</option>
          </select>
        </div>

        <hr />

        {/* Address */}
        <div className="row mb-4">
          <div className="col">
            <div className="form-outline">
              <input
                type="number"
                value={unit_number}
                onChange={(e) => setUnitNo(e.target.value)}
                id="unitnumber"
                className="form-control"
                placeholder="Entert the Unit Number"
              />
            </div>
          </div>
          <div className="col">
            <div className="form-outline">
              <input
                type="number"
                value={street_number}
                onChange={(e) => setStreetNo(e.target.value)}
                id="streetaddress"
                className="form-control"
                placeholder="Entert the Street Number"
              />
            </div>
          </div>
        </div>

        <div className="row mb-4">
          <div className="col">
            <div className="form-outline">
              <input
                type="text"
                value={addressLine1}
                onChange={(e) => setAddressl1(e.target.value)}
                id="addressLine1"
                className="form-control"
                placeholder="Addres Line number 1"
              />
            </div>
          </div>
          <div className="col">
            <div className="form-outline">
              <input
                type="text"
                value={addressLine2}
                onChange={(e) => setAddressl2(e.target.value)}
                id="addressLine2"
                className="form-control"
                placeholder="Addres Line number 2"
              />
            </div>
          </div>
        </div>

        <div className="row mb-4">
          <div className="col">
            <div className="form-outline">
              <input
                type="text"
                value={city}
                onChange={(e) => setCity(e.target.value)}
                id="city"
                className="form-control"
                placeholder="Enter the City"
              />
            </div>
          </div>
          <div className="col">
            <div className="form-outline">
              <input
                type="text"
                value={state}
                onChange={(e) => setState(e.target.value)}
                id="state"
                className="form-control"
                placeholder="Enter the State"
              />
            </div>
          </div>
        </div>

        <div className="row mb-4">
          <div className="col">
            <div className="form-outline">
              <input
                type="text"
                value={postalCode}
                onChange={(e) => setPostalCode(e.target.value)}
                id="postalcode"
                className="form-control"
                placeholder="Enter the Postal Code"
              />
            </div>
          </div>
          <div className="col">
            <div className="form-outline">
              <input
                type="text"
                value={country}
                onChange={(e) => setCountry(e.target.value)}
                id="country"
                className="form-control"
                placeholder="Enter the Country"
              />
            </div>
          </div>
        </div>

        <hr />

        {/* age and dob */}
        <div className="row mb-4">
          <div className="col">
            <div className="form-outline">
              <input
                type="number"
                value={age}
                onChange={(e) => setAge(e.target.value)}
                id="age"
                className="form-control"
                placeholder="Enter the Age"
              />
            </div>
          </div>

          <div className="col">
            <div className="form-outline">
              <input
                type="text"
                value={dob}
                onChange={(e) => setDob(e.target.value)}
                id="dob"
                className="form-control"
                placeholder="Enter the Date Of Birth (yyyy-mm-dd)"
              />
            </div>
          </div>
        </div>

        {/* Submit button */}
        <div className="text-center">
          <button type="submit" className="btn btn-primary btn-block mb-4 ">
            Register
          </button>
        </div>

        {/* Register buttons */}
        {/* <div className="text-center">
          <p>or sign up with:</p>
          <button type="button" className="btn btn-secondary btn-floating mx-1">
            <i className="fab fa-facebook-f" />
          </button>
          <button type="button" className="btn btn-secondary btn-floating mx-1">
            <i className="fab fa-google" />
          </button>
          <button type="button" className="btn btn-secondary btn-floating mx-1">
            <i className="fab fa-twitter" />
          </button>
          <button type="button" className="btn btn-secondary btn-floating mx-1">
            <i className="fab fa-github" />
          </button>
        </div> */}
      </form>
    </div>
  )
}

export default Register
